package com.sun.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Emulator {
	private Robot emulate = null;

	

	public Emulator() {
		try {
			emulate = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void emulateKeypress(String rkey) {
		try{
		System.out.println("Emulate " + rkey);
		emulate.keyPress(getKeyCode(rkey));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int getKeyCode(String key) {
		int event = 0;
		switch (key) {
		case "UP":
			event = KeyEvent.VK_UP;
			
			break;
		case "DOWN":
			event = KeyEvent.VK_DOWN;
			
			break;
		case "LEFT":
			event = KeyEvent.VK_LEFT;
			
			break;
		case "RIGHT":
			event = KeyEvent.VK_RIGHT;
			
			break;
		default:
			break;
		}
		
		return event;
	}
}
