package com.example.lacountysouthbaytourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<Place> {

    TextView name;
    TextView city;
    TextView openingDays;
    TextView openingTime;
    TextView description;
    ArrayList<Place> places;


    public ListAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Place place = getItem(position);
        TextView nameTextView = listItemView.findViewById(R.id.placeName);
        nameTextView.setText(place.getName());

        TextView cityTextView = listItemView.findViewById(R.id.city);
        cityTextView.setText(place.getCity());

        ImageView placeImageView = listItemView.findViewById(R.id.placeImageView);
        placeImageView.setImageResource(place.getmImageResourceId());


        return listItemView;
    }
}
