package com.example.swagmence.lasthope.Controller;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.swagmence.lasthope.Model.MarkerMaker;
import com.example.swagmence.lasthope.Model.ReadWrite;
import com.example.swagmence.lasthope.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public SupportMapFragment mapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        //int titles = 5;
        CallMarkerMaker(googleMap, Integer.parseInt(ReadWrite.readFromFile(this)));
    }

    public void CallMarkerMaker(GoogleMap googleMap, int titles) {
        googleMap.clear();
        MarkerMaker markerMaker = new MarkerMaker();
        markerMaker.make_marker(titles);
        LatLng coords = null;
        for (int i = 0; i < markerMaker.markers.length; i++){
            coords = new LatLng(markerMaker.markers[i][0], markerMaker.markers[i][1]);
            googleMap.addMarker(new MarkerOptions().position(coords));
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(coords));

    }

}
