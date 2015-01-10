package com.sun.remotecontrol;

import java.io.IOException;
import java.net.UnknownHostException;

import android.content.Context;
import android.content.Intent;


public class NetworkCall implements Runnable{
	public Context mcontext = null;
	public NetworkCall(Context context){
		mcontext = context;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Intent pageTwo = new Intent(mcontext,ActivitytwoActivity.class);
			pageTwo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mcontext.startActivity(pageTwo);
			/*ActivityOne.conn = new  Socket("10.3.1.18",8991);
			if(ActivityOne.conn!=null){
				System.out.println("Client:Connected");
				Intent pageTwo = new Intent(mcontext,ActivitytwoActivity.class);
				pageTwo.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mcontext.startActivity(pageTwo);
				
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}