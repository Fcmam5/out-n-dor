package com.example.fcmam5.out_n_dor;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import models.PlaceModel;

public class ListPlaces extends AppCompatActivity {
    protected String API_URL = "http://10.0.2.2:3000/api/v1/"; // TODO: This link will change every time I launch my local server
    protected ArrayList<PlaceModel> placesArray = new ArrayList(); // PlaceModel list

    TextView textView;
    ListView listView;
    Intent intent;
    Intent paramIntent;
    String paramTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_places);
        listView = (ListView) findViewById(R.id.list_places);
        intent = new Intent(ListPlaces.this, PlaceDetails.class);
        paramIntent = getIntent();

        paramTmp = paramIntent.getStringExtra("param");

        API_URL += paramTmp;

        getData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView placeName = (TextView) view.findViewById(R.id.place_name);
                String name = placeName.getText().toString();
                int indice = getIndexByString(name);
                Intent intent = new Intent(ListPlaces.this, PlaceDetails.class);
                intent.putExtra("PlaceModel", placesArray.get(indice));
                startActivity(intent);

            }
        });
    }

    public int getIndexByString(String name) {
        for (int i = 0; i < placesArray.size(); i++) {
            if (placesArray.get(i).getName().equals(name)) ;
            return i;
        }
        return -1;
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

    public void getData() {
        try {
            new MyAsynchTask().execute(API_URL);
        } catch (Exception e) {
            Toast.makeText(this, "Error when connecting to the server", Toast.LENGTH_SHORT).show();
        }
    }

    public class MyAsynchTask extends AsyncTask<String, String, String> {
        /**
         * @author Fortas Abdeldjalil (Fcmam5)
         * @version v0.1 (First time doing it :-p )
         * @description fetch API and append it to PlaceModel array
         */
        private JSONObject jsonObject;
        private JSONArray jsonArray;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            placesArray.clear(); // Clearing the Arraylist for new updates
            // TODO: 15/05/17 ulr + extra
        }

        @Override
        protected String doInBackground(String... params) {
            /**
             * Fetch URL and append Results to placesArray
             */

            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                jsonObject = new JSONObject(Stream2String(in));
                jsonArray = jsonObject.getJSONArray("results");

                // Get Data from JSONObject
                String name;
                String address;
                String urban_adr;
                double latt;
                double lng;
                String nature;
                String description;
                String fb;
                String instagram;
                String website;
                String tel;
                String type;
                String city;
                String img;

                placesArray.clear();

                for (int i = 0; i < jsonArray.length(); i++) {
                    latt = jsonArray.getJSONObject(i).has("latt") ?
                            jsonArray.getJSONObject(i).getDouble("latt") : 0;
                    lng = jsonArray.getJSONObject(i).has("long") ?
                            jsonArray.getJSONObject(i).getDouble("long") : 0;
                    urban_adr = getValueOrDefault(jsonArray.getJSONObject(i), "urban_adr");
                    name = getValueOrDefault(jsonArray.getJSONObject(i), "name");
                    address = getValueOrDefault(jsonArray.getJSONObject(i), "address");
                    nature = getValueOrDefault(jsonArray.getJSONObject(i), "nature");
                    description = getValueOrDefault(jsonArray.getJSONObject(i), "description");
                    fb = getValueOrDefault(jsonArray.getJSONObject(i), "fb");
                    instagram = getValueOrDefault(jsonArray.getJSONObject(i), "instagram");
                    website = getValueOrDefault(jsonArray.getJSONObject(i), "website");
                    tel = getValueOrDefault(jsonArray.getJSONObject(i), "tel");
                    type = getValueOrDefault(jsonArray.getJSONObject(i), "type");
                    img = getValueOrDefault(jsonArray.getJSONObject(i), "img");
                    city = getValueOrDefault(jsonArray.getJSONObject(i), "city");

                    //Append new Place Object to Array
                    placesArray.add(
                            new PlaceModel(type, name, address, urban_adr, latt, lng, nature,
                                    description, fb, instagram,
                                    website, tel, city, img)
                    );
                    publishProgress("loading..");

                }

                in.close();
                publishProgress(placesArray.size() + " result found !");

            } catch (Exception e) {
                publishProgress("Error when getting JSON! ");

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            try {
                Toast.makeText(ListPlaces.this, values[0], Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(ListPlaces.this, "Error" + e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            /*
            * Todo: Here you'll have an ArrayList, do whatever you want :-)
            * Example:
            */
            if (paramIntent.getStringExtra("param").equals("random")) {
                intent.putExtra("PlaceModel", placesArray.get(0));
                intent.putExtra("rand", 5);
                startActivity(intent);
            } else {
                PlacesAdapter placeAdapter = new PlacesAdapter(ListPlaces.this, R.layout.list_place_item, placesArray);
                listView.setAdapter(placeAdapter);
            }


        }
    }

    public String Stream2String(InputStream inputStream) {
        /**
         * Converting Stream to String
         * @return String
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String text = "";

        try {
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
            }
            inputStream.close();
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        return text;
    }

    private String getValueOrDefault(JSONObject jsonObject, String field) throws Exception {
        /**
         * Check if the JSON object has the given field and return it, or return an empty string
         */
        return jsonObject.has(field) ? jsonObject.getString(field) : "";
    }

}
