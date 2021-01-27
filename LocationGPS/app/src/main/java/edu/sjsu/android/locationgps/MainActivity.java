package edu.sjsu.android.locationgps;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowLocation;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowLocation = findViewById(R.id.btnShowLocation);
        //show Location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //create class object
                gps = new GPSTracker(MainActivity.this);
                Location location = gps.getLocation();
                //check if GPS enabled
                if (gps.canGetLocation()) {
                    double latitude = location.getLatitude();
                    double longitutde = location.getLongitude();
                    Toast.makeText(getApplicationContext(), "You Location is - \nLat "
                            + latitude + "\nLong: " + longitutde, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
