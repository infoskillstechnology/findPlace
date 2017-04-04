package com.example.metro.nearbyplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String GOOGLE_API_KEY = "AIzaSyBzKzJVRHA_vQC6UTaNIYc-jdj7gtG-mxU";
    private Button find;
    public static EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find = (Button)findViewById(R.id.button);
        text = (EditText) findViewById(R.id.placeName);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = text.getText().toString();
                StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                googlePlacesUrl.append("location=" + 28.458359 + "," +  76.969310);
                googlePlacesUrl.append("&radius=" + 5000);
                googlePlacesUrl.append("&types=" + type);
                googlePlacesUrl.append("&sensor=true");
                googlePlacesUrl.append("&key=" + GOOGLE_API_KEY);
                GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask();
                Object[] toPass = new Object[1];
                toPass[0] = googlePlacesUrl.toString();
                googlePlacesReadTask.execute(toPass);
                Log.d("passResult ",toPass[0].toString());
            }
        });
    }
}
