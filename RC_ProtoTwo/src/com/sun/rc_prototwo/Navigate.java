package com.sun.rc_prototwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sun.CONSTANTS.CONSTANTS;
import com.sun.sensor.Direction;

public class Navigate extends Activity {

	private Button start,stop;
	private EditText status;
	private OnClickListener buttonClick;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layouttwo);
		start = (Button)findViewById(R.id.button1);
		stop = (Button)findViewById(R.id.button2);
		status = (EditText)findViewById(R.id.editText1);
		CONSTANTS.sensorHandler = new Direction(CONSTANTS.client, getApplicationContext());
		bindClickListener();
	}	

	public  void bindClickListener(){
		buttonClick = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.button1://start
					Toast.makeText(getApplicationContext(), "Sensor Started", Toast.LENGTH_LONG);
					CONSTANTS.sensorHandler.registerListener();
					break;
				case R.id.button2://stop
					CONSTANTS.sensorHandler.deRegisterListener();
					break;
				default:
					break;
				}
				
			}
		};
		start.setOnClickListener(buttonClick);
		stop.setOnClickListener(buttonClick);
	}
}
