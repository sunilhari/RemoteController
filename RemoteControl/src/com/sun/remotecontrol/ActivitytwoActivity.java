package com.sun.remotecontrol;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;



public class ActivitytwoActivity extends Activity {
	public WebSocketClient mWebSocketClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layouttwo);
		Button up = (Button) findViewById(R.id.button1);
		Button down = (Button) findViewById(R.id.button2);
		Button left = (Button) findViewById(R.id.button3);
		Button right = (Button) findViewById(R.id.button4);
		up.setOnClickListener(onClickListener);
		down.setOnClickListener(onClickListener);
		left.setOnClickListener(onClickListener);
		right.setOnClickListener(onClickListener);
		connectToWebSocketServer();
	}

	@Override
	public void onBackPressed() {
		this.finish();
	};

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String key = null;
			
			switch (v.getId()) {
			case R.id.button1:// up
				key = "UP";
				break;
			case R.id.button2:// down
				key = "DOWN";
				break;
			case R.id.button3:// left
				key = "LEFT";
				break;
			case R.id.button4:// right
				key = "RIGHT";
				break;
			default:
				break;
			}
			
			mWebSocketClient.send(key);
		}
	};
	
	public void connectToWebSocketServer(){
		try {
			Log.i("Client", "Trying to connect to websocket server");
			//URI uri = new URI("ws://10.3.1.18:8090");
			Log.d("Client","Server IP:"+ActivityOne.serverAddress);
			URI uri = new URI("ws://"+ActivityOne.serverAddress);
			mWebSocketClient = new WebSocketClient(uri) {
				
				@Override
				public void onOpen(ServerHandshake arg0) {
					Log.d("Client","Socket Opened");
					
				}
				
				@Override
				public void onMessage(String arg0) {
					Log.d("Client","Message Recieved");
					
				}
				
				@Override
				public void onError(Exception arg0) {
					Log.d("Client","Error");
					
				}
				
				@Override
				public void onClose(int arg0, String arg1, boolean arg2) {
					Log.d("Client","Socket Closed");
					
				}
			};
			mWebSocketClient.connect();
			GetDirection direction = new GetDirection(getApplicationContext(), mWebSocketClient);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
