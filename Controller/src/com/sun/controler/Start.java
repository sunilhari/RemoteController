package com.sun.controler;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.UI.ServerWindow;
import com.sun.constants.CONSTANTS;

public class Start {

	public ServerWindow window;
	public Start(){
		setServerIp();
		showUIWindow();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		Start begin = new Start();
		
	}
	
	public void setServerIp(){
		try {
			InetAddress serverIp = InetAddress.getLocalHost();
			CONSTANTS.SERVER_IP = serverIp.getHostAddress();
			System.out.println(CONSTANTS.SERVER_IP);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showUIWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ServerWindow();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
