package com.example.fcmam5.out_n_dor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button boutonSport;
    Button boutonPark;
    Button boutonLibrary;
    Button boutonTourism;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this, ListPlaces.class);
        boutonSport = (Button) findViewById(R.id.buttonSport);
        boutonPark = (Button) findViewById(R.id.buttonPark);
        boutonLibrary = (Button) findViewById(R.id.buttonLibrary);
        boutonTourism = (Button) findViewById(R.id.buttonTourism);
    }

    protected void goToPark(View view) {
        intent.putExtra("param", "park");
        startActivity(intent);
    }

    protected void goToSport(View view) {
        intent.putExtra("param", "sport");
        startActivity(intent);
    }

    protected void goToLibrary(View view) {
        intent.putExtra("param", "library");
        startActivity(intent);
    }

    protected void goToTourism(View view) {
        intent.putExtra("param", "tourism");
        startActivity(intent);
    }

    protected void goToRandom(View view) {
        intent.putExtra("param", "random");
        startActivity(intent);
    }
}
