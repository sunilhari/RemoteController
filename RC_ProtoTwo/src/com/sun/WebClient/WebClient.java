package com.sun.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import android.util.Log;

public class WebClient {
	private WebSocketClient newClient;
	public WebSocketClient connectToServer(String serverAddress) throws URISyntaxException{
		URI uri = new URI("ws://"+serverAddress);
		newClient = new WebSocketClient(uri) {
			
			@Override
			public void onOpen(ServerHandshake arg0) {
				// TODO Auto-generated method stub
				Log.d("Client", "Connected to Server");
				
			}
			
			@Override
			public void onMessage(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(Exception arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClose(int arg0, String arg1, boolean arg2) {
				// TODO Auto-generated method stub
				Log.d("Client", "Connected Closed by Server");
				
			}
		};
		newClient.connect();
		return newClient;
		
	}
	
}
