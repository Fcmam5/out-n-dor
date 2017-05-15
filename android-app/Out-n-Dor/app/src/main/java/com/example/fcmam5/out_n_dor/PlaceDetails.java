package com.example.fcmam5.out_n_dor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import models.PlaceModel;

public class PlaceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        Intent intent = getIntent();
        PlaceModel placeModel = (PlaceModel) intent.getSerializableExtra("PlaceModel");
        TextView textView = (TextView) findViewById(R.id.p_name);
        textView.setText(placeModel.getName());
    }
}
