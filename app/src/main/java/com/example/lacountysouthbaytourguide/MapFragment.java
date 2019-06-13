package com.example.lacountysouthbaytourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {

    private double latitude;
    private double longitude;

    public MapFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        latitude = this.getArguments().getDouble("lat");
        longitude = this.getArguments().getDouble("long");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        if(supportMapFragment != null){
            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    googleMap.clear();


                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(latitude,longitude))
                            .title("Iron Man")
                            .snippet("His Talent : Plenty of money"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude), 13.0f));

                    //CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(33.8707897,-118.4331761)).zoom(14.0f).build();
                    //CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

                    //googleMap.moveCamera(cameraUpdate);
                    //googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(33.8707897,-118.4331761)));

                    /*CameraPosition googlePlex = CameraPosition.builder()
                            .target(new LatLng(37.4219999,-122.0862462))
                            .zoom(10)
                            .bearing(0)
                            .tilt(45)
                            .build();

                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(33.8707897,-118.4331761))
                            .title("Iron Man")
                            .snippet("His Talent : Plenty of money"));

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(37.3092293,-122.1136845))
                            .title("Captain America"));*/
                }
            });
        }else{
            System.out.println("SUPPORT MAP FRAGMENT = NULL");
        }
    }
}
