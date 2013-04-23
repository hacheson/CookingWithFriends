package server;
import java.io.IOException;
import java.util.LinkedList;

/**
 * A group ofClientHandlers representing all active windows.
 * Modified version of clientPool from lab.
 */
public class ClientPool {
	private LinkedList<ClientHandler> _clients;
	
	/**
	 * Initialize a new {@link ClientPool}.
	 */
	public ClientPool() {
		_clients = new LinkedList<ClientHandler>();
	}
	
	/**
	 * Add a new client to the chat room.
	 * 
	 * @param client to add
	 */
	public synchronized void add(ClientHandler client) {
		_clients.add(client);
	}
	
	/**
	 * Remove a client from the pool. Only do this if you intend to clean up
	 * that client later.
	 * 
	 * @param client to remove
	 * @return true if the client was removed, false if they were not there.
	 */
	public synchronized boolean remove(ClientHandler client) {
		return _clients.remove(client);
	}
	
	/**
	 * Send a RequestReturn to clients in the pool.
	 */
	public synchronized void broadcast(RequestReturn toReturn) {
		for (ClientHandler client : _clients) {
			client.send(toReturn);
		}
	}
	
	/**
	 * Close all ClientHandlers and empty the pool
	 */
	public synchronized void killall() {

		for (ClientHandler client : _clients) {
			try {
				client.kill();
			} catch (IOException e) {
				// There's nothing we can do here.
			}
		}

		_clients.clear();
	}
}