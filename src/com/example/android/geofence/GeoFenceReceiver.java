package com.example.android.geofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class GeoFenceReceiver extends BroadcastReceiver {
	public GeoFenceReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		
		 // Check the action code and determine what to do
        String action = intent.getAction();

        // Intent contains information about errors in adding or removing geofences
        if (TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCE_ERROR)) {
        	Toast.makeText(context,"ACTION_GEOFENCE_ERROR", Toast.LENGTH_LONG).show();

        // Intent contains information about successful addition or removal of geofences
        } else if (
                TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCES_ADDED)
                ||
                TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCES_REMOVED)) {
        	Toast.makeText(context,"addition or removal of geofences", Toast.LENGTH_LONG).show();

        // Intent contains information about a geofence transition
        } else if (TextUtils.equals(action, GeofenceUtils.ACTION_GEOFENCE_TRANSITION)) {
        	Toast.makeText(context,"ACTION_GEOFENCE_TRANSITION", Toast.LENGTH_LONG).show();

        // The Intent contained an invalid action
        } else {
            Log.e(GeofenceUtils.APPTAG, context.getString(R.string.invalid_action_detail, action));
            Toast.makeText(context, R.string.invalid_action, Toast.LENGTH_LONG).show();
        }
	}
}
