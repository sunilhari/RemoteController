package com.sun.server;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import com.sun.constants.CONSTANTS;
import com.sun.utils.Emulator;
public class WSocketServer extends WebSocketServer {

	static InetSocketAddress address = new InetSocketAddress(CONSTANTS.SERVER_IP, CONSTANTS.PORT_NUMBER);
	static Emulator emulate;
	public WSocketServer() throws UnknownHostException {
		
		super(address);
		emulate = new Emulator();
		System.out.println("Staring Server @ "+address.toString());
		this.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(WebSocket arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(WebSocket conn, String arg1) {
		// TODO Auto-generated method stub
		
		emulate.emulateKeypress(arg1);
		
	}

	@Override
	public void onOpen(WebSocket arg0, ClientHandshake arg1) {
		// TODO Auto-generated method stub
		System.out.println("New Connection from client:"+arg0.getRemoteSocketAddress());
		
	}
	

}
