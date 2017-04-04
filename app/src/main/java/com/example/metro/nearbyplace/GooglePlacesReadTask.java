package com.example.metro.nearbyplace;

import android.os.AsyncTask;
import android.util.Log;


/**
 * Created by Metro on 22-02-2017.
 */
public class GooglePlacesReadTask extends AsyncTask<Object, Integer, String> {
    String googlePlacesData = null;
    @Override
    protected String doInBackground(Object... inputObj) {

        try {
            String googlePlacesUrl = (String) inputObj[0];
            Http http = new Http();
            googlePlacesData = http.read(googlePlacesUrl);
        } catch (Exception e) {
            Log.d("Google Place Read Task", e.toString());
        }
        return googlePlacesData;
    }

    protected void onPostExecute(String result) {
        PlacesDisplayTask placesDisplayTask = new PlacesDisplayTask();
        Object[] toPass = new Object[2];
        toPass[0] = result;
        placesDisplayTask.execute(toPass);
    }
}
