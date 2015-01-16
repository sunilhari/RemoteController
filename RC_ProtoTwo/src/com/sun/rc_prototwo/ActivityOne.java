package com.sun.rc_prototwo;

import java.net.URISyntaxException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.sun.CONSTANTS.CONSTANTS;
import com.sun.WebClient.WebClient;

public class ActivityOne extends Activity {

	EditText serverAddress;
	Button connectBtn;
	WebClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layoutone);
		serverAddress = (EditText) findViewById(R.id.editText1);
		connectBtn = (Button) findViewById(R.id.button1);
		 client = new WebClient(getApplicationContext());
		 bindListeners();
	}

	public void bindListeners() {
		OnClickListener amListening = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.button1:
					String value = serverAddress.getText().toString();
					if (validateIp(value)) {
						try {
							CONSTANTS.client = client.connectToServer(value);
							
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;

				default:
					break;
				}

			}
		};
		connectBtn.setOnClickListener(amListening);
	}

	public boolean validateIp(String value) {
		if (value.trim().isEmpty())
			return false;
		return true;
	}

	

}
