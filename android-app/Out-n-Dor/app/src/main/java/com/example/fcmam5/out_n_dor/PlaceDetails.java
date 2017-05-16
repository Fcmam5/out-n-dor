package com.example.fcmam5.out_n_dor;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import models.PlaceModel;

public class PlaceDetails extends FragmentActivity implements OnMapReadyCallback {
    Intent intent;
    GoogleMap mMap;
    PlaceModel placeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        intent = getIntent();
        placeModel = (PlaceModel) intent.getSerializableExtra("PlaceModel");

        TextView name = (TextView) findViewById(R.id.p_name);
        name.setText(placeModel.getName());

        TextView city = (TextView) findViewById(R.id.p_city);
        city.setText(city.getText().toString() + placeModel.getCity());

        TextView urbanAdress = (TextView) findViewById(R.id.p_urban_adr);
        urbanAdress.setText(urbanAdress.getText().toString() + placeModel.getUrban_adr());

        TextView adress = (TextView) findViewById(R.id.p_adr);
        adress.setText(adress.getText().toString() + placeModel.getAddress());

        TextView description = (TextView) findViewById(R.id.p_description);
        description.setText(description.getText().toString() + "\n" + placeModel.getDescription());

        TextView tel = (TextView) findViewById(R.id.p_telephone);
        tel.setText(tel.getText().toString() + placeModel.getTel());

        TextView facebook = (TextView) findViewById(R.id.p_facebook);
        facebook.setText(facebook.getText().toString() + placeModel.getFb());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Check if the current activity is came from a list or from MainActivity with Random
     * If the current activity was came from Random, catch the Return button and redirect it to MainActivity
     */
    @Override
    public void onBackPressed() {
        if (intent.getIntExtra("rand", 0) != 0) {
            startActivity(new Intent(PlaceDetails.this, MainActivity.class));
        } else {
            super.onBackPressed();
        }
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
        mMap = googleMap;
        double latt = placeModel.getLatt();
        double longitude = placeModel.getLng();

        // Add a marker in Sydney and move the camera
        LatLng positions = new LatLng(latt, longitude);
        mMap.addMarker(new MarkerOptions().position(positions).title(placeModel.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(positions));
    }
}
