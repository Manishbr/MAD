package com.sssa.gps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonShowLocation;
    GPStracer gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonShowLocation = (Button) findViewById(R.id.button);
        buttonShowLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gps = new GPStracer(MainActivity.this);
                if(gps.getLocation() != null){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast.makeText(getApplicationContext(), "Your Location is \nLatitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Your Location is currently not available.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
