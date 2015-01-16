package com.sun.sensor;

import org.java_websocket.client.WebSocketClient;

import com.sun.CONSTANTS.CONSTANTS;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;

public class Direction {
	private SensorManager senMan;
	private SensorEventListener senLis;
	private Context context;
	private WebSocketClient webClient;
	private String[] directions = new String[2];
	private String[] prevDirections = new String[2];
	public Direction(WebSocketClient client, Context mContext) {
		// TODO Auto-generated constructor stub
		webClient = client;
		context = mContext;
		initSensors();
		//registerListener();
	}

	public void initSensors() {
		senMan = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);
		
		senLis = new SensorEventListener() {
			WindowManager winMan = (WindowManager) context
					.getSystemService(context.WINDOW_SERVICE);
			Display disp = winMan.getDefaultDisplay();
			int displayRotation = disp.getRotation();

			@Override
			public void onSensorChanged(SensorEvent event) {
				// TODO Auto-generated method stub
				float[] sensorReading = new float[2];
				sensorReading = adjustAccelOrientation(displayRotation, event.values);
				
				String key = "";
				//UP DOWN RIGHT LEFT
				if(sensorReading[1]>CONSTANTS.thresholdY){
					key = "10";//up
				}
				else if(sensorReading[1]<-CONSTANTS.thresholdY){
					key = "01";//down
				}
				else{
					key = "00";
				}
				if(sensorReading[0]>CONSTANTS.thresholdX){
					key += "01";//left
				}
				else if(sensorReading[0]<-CONSTANTS.thresholdX){
					key += "10";//right
				}
				else{
					key += "00";
				}
				int code = Integer.parseInt(key, 2);
				webClient.send(""+code);
			}

			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {
				// TODO Auto-generated method stub

			}
		};
	}

	public void registerListener() {
		senMan.registerListener(senLis,
				senMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_FASTEST);
	}

	public void deRegisterListener() {
		senMan.unregisterListener(senLis);
	}

	private static float[] adjustAccelOrientation(int displayRotation,
			float[] eventValues) {
		float[] adjustedValues = new float[3];

		final int axisSwap[][] = { { 1, -1, 0, 1 }, // ROTATION_0
				{ -1, -1, 1, 0 }, // ROTATION_90
				{ -1, 1, 0, 1 }, // ROTATION_180
				{ 1, 1, 1, 0 } }; // ROTATION_270

		final int[] as = axisSwap[displayRotation];
		adjustedValues[0] = (float) as[0] * eventValues[as[2]];
		adjustedValues[1] = (float) as[1] * eventValues[as[3]];
		adjustedValues[2] = eventValues[2];

		return adjustedValues;
	}
}
