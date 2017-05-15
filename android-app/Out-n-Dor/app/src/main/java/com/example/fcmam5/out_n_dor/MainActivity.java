package com.example.fcmam5.out_n_dor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
     Button boutonSport= (Button)findViewById(R.id.buttonSport);
    Button boutonPark= (Button)findViewById(R.id.buttonPark);
    Button boutonLibrary= (Button)findViewById(R.id.buttonLibrary);
    Button boutonTourism= (Button)findViewById(R.id.buttonTourism);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickFunction(View view) {
        Intent intent = new Intent(MainActivity.this, ListPlaces.class);
        intent.putExtra("param", "tourism");
        startActivity(intent);
         switch(view.getId()){
            case R.id.buttonSport:
                intent.putExtra("sport",boutonSport.getText().toString().toLowerCase());
                break;
            case R.id.buttonLibrary:
                intent.putExtra("library",boutonLibrary.getText().toString().toLowerCase());
                break;

            case R.id.buttonPark:
                intent.putExtra("park",boutonPark.getText().toString().toLowerCase());
                break;
            case R.id.buttonTourism:
                intent.putExtra("tourism",boutonTourism.getText().toString().toLowerCase());
                break;
        }
        
        
    }
}
