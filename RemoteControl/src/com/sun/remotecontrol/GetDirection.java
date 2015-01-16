package com.sun.remotecontrol;

import org.java_websocket.client.WebSocketClient;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class GetDirection {
	private SensorManager mSensorManager;
	private float mAccel; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity
	private long lastUpdate = System.currentTimeMillis();
	private WebSocketClient websocket;
	private Context mContext;
	public GetDirection(Context mCxt, WebSocketClient mWebSocketClient) {
		mSensorManager = (SensorManager) mCxt
				.getSystemService(Context.SENSOR_SERVICE);
		mSensorManager.registerListener(mSensorListener,
				mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
		mAccelLast = SensorManager.GRAVITY_EARTH;
		websocket = mWebSocketClient;
		mContext = mCxt;
	}

	private final SensorEventListener mSensorListener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				WindowManager winMan = (WindowManager)mContext.getSystemService(mContext.WINDOW_SERVICE);
				Display disp = winMan.getDefaultDisplay();
				int displayRotation = disp.getRotation();
				//float[] values = event.values;
				float [] values = adjustAccelOrientation(displayRotation, event.values);

				// Movement
				float x = values[0];
				float y = values[1];
				float z = values[2];

				Log.d("Coords", "X: " + x + "  Y: " + y + "  Z: " + z);
					if(websocket!=null){
				
					if(x>3){
						websocket.send("LEFT");
						Log.d("Client", "LEFT");
					}
					else
					{
						websocket.send("RIGHT");
						Log.d("Client", "RIGHT");
					}
					if(y>3){
						websocket.send("UP");
						Log.d("Client", "UP");
					}
					else{
						websocket.send("DOWN");
						Log.d("Client", "DOWN");
					}

				}}
			}

		

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};

	public double Round(float value, int round) {
		Log.d("Client", "Actual Value:" + value);
		int roundto = round * 10;
		double returnValue = (double) Math.round(value * roundto) / roundto;
		return returnValue;
	}

	public static float[] adjustAccelOrientation(int displayRotation,
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
