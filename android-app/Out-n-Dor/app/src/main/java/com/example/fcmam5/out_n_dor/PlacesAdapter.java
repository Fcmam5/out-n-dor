package com.example.fcmam5.out_n_dor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import models.PlaceModel;

/**
 * Created by fcmam5 on 05/05/17.
 */

public class PlacesAdapter extends ArrayAdapter<PlaceModel> {

    Context context;
    int layoutResourceId;
    ArrayList<PlaceModel> data = null;

    public PlacesAdapter(Context context, int resource, List<PlaceModel> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = (ArrayList) objects;
    }

    private class PlaceHolder {
        public ImageView place_icon;
        public TextView place_name;
        public TextView place_city;
        public ImageView place_icon_price;
        public TextView place_price;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlaceHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new PlaceHolder();
            holder.place_icon = (ImageView) row.findViewById(R.id.place_icon);
            holder.place_name = (TextView) row.findViewById(R.id.place_name);
            holder.place_city = (TextView) row.findViewById(R.id.place_city);
            holder.place_icon = (ImageView) row.findViewById(R.id.place_price_icon);
            holder.place_price = (TextView) row.findViewById(R.id.place_price);

            row.setTag(holder);
        } else {
            holder = (PlaceHolder) row.getTag();
        }

        PlaceModel item = data.get(position);
        holder.place_name.setText(item.getName().toString());
        Log.e("",item.getImg());
//        Picasso.with(this.getContext()).load(item.getImg()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.place_icon, new com.squareup.picasso.Callback(){
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
        holder.place_city.setText(item.getCity().toString());
        String nature = item.getNature();
        //int iconResource = getContext().getResources().getIdentifier("ic_launcher", null, getContext().getPackageName());
        //Drawable res = getContext().getResources().getDrawable(iconResource);
        //holder.place_icon_price.setImageDrawable(res);
        holder.place_price.setText(item.getNature().toString());

        return row;
    }


}
