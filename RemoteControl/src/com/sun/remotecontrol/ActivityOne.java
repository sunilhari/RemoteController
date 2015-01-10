package com.sun.remotecontrol;

import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityOne extends Activity implements OnClickListener {
public static String serverAddress = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layoutone);
		Button accept = (Button) findViewById(R.id.button1);
		accept.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		this.finish();
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.button1) {
			Toast.makeText(getApplicationContext(), "Button Clicked",
					Toast.LENGTH_LONG).show();
			EditText text = (EditText)findViewById(R.id.editText1);
			serverAddress = text.getText().toString();
			Intent pageTwo = new Intent(this,ActivitytwoActivity.class);
			startActivity(pageTwo);
		}

	}


}
