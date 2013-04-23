package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;

import UserInfo.Account;

/**
 * Encapsulate IO for the given client.
 * Runs an input loop and adds task to taskPool
 * based on the request. 
 * Sends RequestReturn object to handler.
 * Modified ClientHandler from lab4
 */
public class ClientHandler extends Thread {
	private ClientPool _pool;
	private Socket _client;
	private BufferedReader _input;
	private ObjectOutputStream _objectOut;
	private ExecutorService _taskPool;
	
	/**
	 * Thread for the client. Handles input and launches requests.
	 */
	public ClientHandler(ClientPool pool, Socket client, ExecutorService taskPool) throws IOException {
		if (pool == null || client == null) {
			throw new IllegalArgumentException("Cannot accept null arguments.");
		}
		
		_pool = pool;
		_client = client;
		_taskPool = taskPool;
		_input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		_objectOut = new ObjectOutputStream(client.getOutputStream()) {
			@Override
			public void close() {
				try {
					super.close();
				} catch (IOException e) {
				}
			}
		};
	}
	
	/**
	 * Receive data from the client. Input is in the form 
	 * of a string. Launch request accordingly.
	 */
	public void run(){
		try {
				String input;
				while(_client.isConnected() && (input = _input.readLine()) != null){
					if(input.equals("Close me")){
						kill();
						break;
					}
					
					else if(input.startsWith("Check user/password:")){
						//call to data base for userpassword
					}
					
					else if(input.startsWith("Get account:")){
						//call to data base for account
					}
				
					else if(input.startsWith("Get kitchen:")){
						//call to database for kitchen
					}
					
					else{
						continue;			
					}
			}
		} catch (IOException  e) {
				try {
					kill();
				} catch (IOException e1) {
					//try again
					try {
						kill();
					} catch (IOException e2) {
						//Ignore
					}
				}
		} 
	}
	
	/**
	 * Send a RequestReturn to the client via the socket
	 */
	public synchronized void send(RequestReturn toReturn) {
		if(toReturn != null){
			try {
				_objectOut.writeObject(toReturn);
				_objectOut.flush();
				_objectOut.reset();
			} catch (IOException e) {
				try {
					kill();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * Close this socket and its related streams.
	 */
	public void kill() throws IOException {
		_input.close();
		try{
			_objectOut.close();
		} catch(SocketException e){
			
		}
		_client.close();
		_pool.remove(this);
	}	
	
	
	public void checkPassword(String input){
		// 1. Query database.
		// 2. Check if password = password form database.
	}
	
	public void getAccount(String input){
		String[] line = input.split("\\t");
		if(line.length==2){
			_taskPool.execute(new AccountRequest(this, line[2]));
		}
	}
	
	public void getKitchen(String input){
		String[] line = input.split("\\t");
		if(line.length==2){
			_taskPool.execute(new KitchenRequest(this, line[2]));
		}
	}
	
	
	/**else if(input.startsWith("Check user/password:")){
		//call to data base for userpassword
	}
	
	else if(input.startsWith("Get account:")){
		//call to data base for account
	}

	else if(input.startsWith("Get kitchen:")){
		//call to database for kitchen
	} **/
	
}