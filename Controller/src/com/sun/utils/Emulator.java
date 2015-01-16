package com.sun.utils;

import java.awt.AWTException;
import java.awt.Robot;

public class Emulator {
	private Robot emulate = null;
	private KeyMap mapper;

	public Emulator() {
		try {
			emulate = new Robot();
			mapper = new KeyMap();//argument indicates the type of key to be used
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void emulateKeypress(String rkey) {
		int code = Integer.parseInt(rkey.trim());
		emulate.keyRelease(mapper.UP);
		emulate.keyRelease(mapper.LEFT);
		emulate.keyRelease(mapper.DOWN);
		emulate.keyRelease(mapper.RIGHT);
		switch (code) {
		case 1:// left
			emulate.keyPress(mapper.LEFT);
			break;
		case 2:// right
			emulate.keyPress(mapper.RIGHT);
			break;
		case 4:// down
			emulate.keyPress(mapper.DOWN);
			break;
		case 8:// up
			emulate.keyPress(mapper.UP);
			break;
		case 6:// down right
			emulate.keyPress(mapper.DOWN);
			emulate.keyPress(mapper.RIGHT);
			break;
		case 9:// up left
			emulate.keyPress(mapper.UP);
			emulate.keyPress(mapper.LEFT);
			break;
		case 5:// down left
			emulate.keyPress(mapper.DOWN);
			emulate.keyPress(mapper.LEFT);
			break;
		case 10:// up right
			emulate.keyPress(mapper.UP);
			emulate.keyPress(mapper.RIGHT);
			break;
		default:
			emulate.keyRelease(mapper.UP);
			emulate.keyRelease(mapper.LEFT);
			emulate.keyRelease(mapper.DOWN);
			emulate.keyRelease(mapper.RIGHT);
			break;
		}
	}
}
