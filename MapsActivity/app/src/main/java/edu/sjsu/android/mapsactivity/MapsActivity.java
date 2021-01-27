package edu.sjsu.android.mapsactivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;

public class MapsActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private final LatLng LOCATION_UNIV = new LatLng(37.335371, -121.881050);
    private final LatLng LOCATION_CS = new LatLng(37.333714, -121.881860);
    private GoogleMap map;

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        button1 = findViewById(R.id.btnUniv);
        button2 = findViewById(R.id.btnCity);
        button3 = findViewById(R.id.btnCS);

        OnMapReadyCallback onMap = new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        Marker marker = map.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title("Marker added to the map"));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(LocationsDB.LAT, marker.getPosition().latitude);
                        contentValues.put(LocationsDB.LNG, marker.getPosition().longitude);
                        contentValues.put(LocationsDB.ZOOM, map.getCameraPosition().zoom);

                        LocationInsertTask insert = new LocationInsertTask();
                         insert.execute(contentValues);
                        Toast.makeText(getBaseContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(LatLng latLng) {
                        map.clear();
                        LocationDeleteTask deleteTask = new LocationDeleteTask();
                        deleteTask.execute();
                        Toast.makeText(getBaseContext(), "All markers removed", Toast.LENGTH_SHORT).show();
                        // create an instance of location delete task
                        // delete all the rows from database
                    }
                });
            }
        };

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(onMap);

    getSupportLoaderManager().initLoader(0, null,  this);
    }


    public void onClick_CS(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_CS, 18);
        map.animateCamera(update);
    }

    public void onClick_Univ(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 14);
        map.animateCamera(update);
    }

    public void onClick_City(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 10);
        map.animateCamera(update);
    }

    private class LocationInsertTask extends AsyncTask<ContentValues, Void, Void> {
        @Override
        protected Void doInBackground(ContentValues... contentValues) {

            getContentResolver().insert(LocationsContentProvider.CONTENT_URI, contentValues[0]);
            return null;
        }
    }

    private class LocationDeleteTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... params) {

            getContentResolver().delete(LocationsContentProvider.CONTENT_URI, null, null);
            return null;
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Loader<Cursor> c = null;
        // Uri to the content provider LocationsContentProvider
        Uri uri = LocationsContentProvider.CONTENT_URI;
        // Fetches all the rows from locations table
        return new CursorLoader(this, uri, null, null, null, null);
    }

    private void drawMarker(LatLng point){
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();
        // Setting latitude and longitude for the marker
        markerOptions.position(point);
        // Adding marker on the Google Map
        map.addMarker(markerOptions);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> arg0,
                               Cursor arg1) {
        int locationCount = 0;
        double latitude=0;
        double longitude=0;
        float zoom=0;

        // Number of locations available in the SQLite database table
        locationCount = arg1.getCount();
        // Move the current record pointer to the first row of the table
        arg1.moveToFirst();

        for(int i=0;i<locationCount;i++){
            // Get the latitude
            latitude = arg1.getDouble(arg1.getColumnIndex(LocationsDB.LAT));
            // Get the longitude
            longitude = arg1.getDouble(arg1.getColumnIndex(LocationsDB.LNG));
            // Get the zoom level
            zoom = arg1.getFloat(arg1.getColumnIndex(LocationsDB.ZOOM));
            // Creating an instance of LatLng to plot the location in Google Maps
            LatLng location = new LatLng(latitude, longitude);
            // Drawing the marker in the Google Maps
            drawMarker(location);
            // Traverse the pointer to the next row
            arg1.moveToNext();
        }

        if(locationCount > 0){
            // Moving CameraPosition to last clicked position
            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude,longitude)));

            // Setting the zoom level in the map on last position  is clicked
            map.animateCamera(CameraUpdateFactory.zoomTo(zoom));

        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
