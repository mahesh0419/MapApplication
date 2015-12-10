package com.example.mahesh.mapapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GoogleMap googleMap;
    ArrayList<LatLng> points;
    LatLng polyline;
    double lat;
    double lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        points = new ArrayList<LatLng>();


        points.add(new LatLng(13.0319572, 77.560509));
        points.add(new LatLng(12.9906324, 77.553344));
        points.add(new LatLng(12.9698858, 77.5332796));
        points.add(new LatLng(12.9241437, 77.5218127));

        // Getting reference to the SupportMapFragment of activity_main.xml
        //SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting GoogleMap object from the fragment
        //googleMap = fm.getMap();

        // Enabling MyLocation Layer of Google Map
        //googleMap.setMyLocationEnabled(true);



        if (googleMap != null) {
            return;
        }
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (googleMap == null) {
            return;
        }
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);


        //MarkerOptions markerOptions = new MarkerOptions();
        //Marker pos_Marker =  googleMap.addMarker(new MarkerOptions().position(starting).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_laumcher)).title("Starting Location").draggable(false));


        //googleMap.addMarker(new MarkerOptions().position(new LatLng(lat , lng)).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_pin)).title("Marker"));
        //googleMap.addMarker(markerOptions);

        PolylineOptions polylineOptions = new PolylineOptions();

        // Create polyline options with existing LatLng ArrayList
        polylineOptions.addAll(points);
        polylineOptions
                .width(5)
                .color(Color.RED);

        // Adding multiple points in map using polyline and arraylist
        googleMap.addPolyline(polylineOptions);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
