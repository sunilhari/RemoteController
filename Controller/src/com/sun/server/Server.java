package com.sun.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.constants.CONSTANTS;
import com.sun.utils.Emulator;
import com.sun.utils.TestClient;

public class Server extends Thread {
	private Emulator emulate = null;

	public Server() {
		System.out.println("Starting server at PORT:" + CONSTANTS.PORT_NUMBER);
		try {
			emulate = new Emulator();
			this.start();// starting the thread
		} catch (Exception e) {
			System.out.println("Unbale to start server at PORT:"
					+ CONSTANTS.PORT_NUMBER);
		}
	}

	public void run() {
		ServerSocket server = null;
		try {
			System.out.println("Staring server.. .. ...");
			server = new ServerSocket(CONSTANTS.PORT_NUMBER);// create a server
																// socket
			//TestClient test = new TestClient();

			Socket client = server.accept();// accept connection from client
			InetAddress clientAddress = client.getInetAddress();// get client
																// address
			System.out.println("Server:Host " + clientAddress.getHostName()
					+ " connected");
			BufferedReader clientReader = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			String key = clientReader.readLine();
			System.out.println(key);
			emulate.emulateKeypress(key);

		} catch (Exception e) {
			System.out.println("Error in running server");
			e.printStackTrace();
		}
	}
}
