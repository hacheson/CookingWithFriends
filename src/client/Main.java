package client;

import java.io.IOException;

public class Main {
	
	private final static int DEFAULT_PORT = 9876;

	public static void main(String[] args) {
		try{
			Client c = new Client(DEFAULT_PORT);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
