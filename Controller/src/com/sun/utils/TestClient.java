package com.sun.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.constants.CONSTANTS;

public class TestClient {
	public TestClient() {
		startClient();
	}

	void startClient() {
		try {
			System.out.println("Starting Client");
			Socket client = new Socket("10.3.1.18", CONSTANTS.PORT_NUMBER);
			if (client != null) {
				System.out.println("Connected to Server");
				DataOutputStream dataOutputStream = new DataOutputStream(
						client.getOutputStream());
				dataOutputStream.writeUTF("012");
				client.close();
			} else {
				System.out.println("Unable to connect to server");
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
