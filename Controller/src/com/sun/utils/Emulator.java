package com.sun.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Emulator {
	private Robot emulate = null;
	private int previousKeyCode = 0;
	

	public Emulator() {
		try {
			emulate = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void emulateKeypress(String rkey) {
		int code = Integer.parseInt(rkey.trim());
		emulate.keyRelease(KeyEvent.VK_W);
		emulate.keyRelease(KeyEvent.VK_A);
		emulate.keyRelease(KeyEvent.VK_S);
		emulate.keyRelease(KeyEvent.VK_D);
		switch (code) {
		case 1://left
			emulate.keyPress(KeyEvent.VK_A);
			break;
		case 2://right
			emulate.keyPress(KeyEvent.VK_D);
			break;
		case 4://down
			emulate.keyPress(KeyEvent.VK_S);
			break;
		case 8://up
			emulate.keyPress(KeyEvent.VK_W);
			break;
		case 6://down right
			emulate.keyPress(KeyEvent.VK_S);
			emulate.keyPress(KeyEvent.VK_D);
			break;
		case 9://up left
			emulate.keyPress(KeyEvent.VK_W);
			emulate.keyPress(KeyEvent.VK_A);
			break;
		case 5://down left
			emulate.keyPress(KeyEvent.VK_S);
			emulate.keyPress(KeyEvent.VK_A);
			break;
		case 10://up right
			emulate.keyPress(KeyEvent.VK_W);
			emulate.keyPress(KeyEvent.VK_D);
			break;
		default:
			emulate.keyRelease(KeyEvent.VK_W);
			emulate.keyRelease(KeyEvent.VK_A);
			emulate.keyRelease(KeyEvent.VK_S);
			emulate.keyRelease(KeyEvent.VK_D);
			break;
		}
	}

	/*public int getKeyCode(String key) {
		int event = 0;
		switch (key) {
		case "UP":
			event = KeyEvent.VK_W;
			
			break;
		case "DOWN":
			event = KeyEvent.VK_S;
			break;
		case "LEFT":
			event = KeyEvent.VK_A;
			
			break;
		case "RIGHT":
			event = KeyEvent.VK_D;
			
			break;
		default:
			break;
		}
		
		return event;
	}*/
}
