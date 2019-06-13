/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lacountysouthbaytourguide;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DetailPageActivity extends FragmentActivity {

    protected static final String TAG = DetailPageActivity.class.getSimpleName();
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private MapFragment mapFragment;
    private ImageView image;
    private TextView name;
    private TextView city;
    private TextView description;
    private ImageView topBackbutton;
    private TextView openingDay;
    private TextView openingTime;
    private TextView address;
    private TextView phoneNumber;
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        image = findViewById(R.id.placeImage);
        name = findViewById(R.id.placeName);
        city = findViewById(R.id.placeCity);
        description = findViewById(R.id.descriptionValue);
        topBackbutton = findViewById(R.id.topBackBtn);
        openingTime = findViewById(R.id.openingTime);
        openingDay = findViewById(R.id.openingDay);
        address = findViewById(R.id.addressValue);
        phoneNumber = findViewById(R.id.phoneNumberValue);


        topBackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
             place = bundle.getParcelable("place");
            int color = bundle.getInt("color");

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                getWindow().setStatusBarColor(color);
            }
            name.setText(place.getName());
            city.setText(place.getCity());
            image.setImageResource(place.getmImageResourceId());
            description.setText(place.getDescription());
            openingTime.setText(place.getOpeningTime());
            openingDay.setText(place.getOpeningDay());
            address.setText(place.getAddress());
            phoneNumber.setText(place.getPhoneNumber());

            if(isServicesOK()){
                initMap();
            }
        }








    }
    public void initMap(){
        Bundle bundle = new Bundle();
        bundle.putDouble("lat", place.getLatitude());
        bundle.putDouble("long", place.getLongitude());
        mapFragment = new MapFragment();
        mapFragment.setArguments(bundle);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        ft.add(R.id.fragment_holder, mapFragment);

        ft.commit();

    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(DetailPageActivity.this);

        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOk: Google Play Services is working");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            // Check if error can be resolved
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(DetailPageActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "We can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
