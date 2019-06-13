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

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * This fragment shows a listview of places to shop at in the southbay
 *
 */

public class ShopFragment extends Fragment {

    ListView listView;
    private DoFragment.OnFragmentInteractionListener callback;
    DoFragment.OnFragmentInteractionListener onFragmentInteractionListener;

    public ShopFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatfragment, container, false);

        final ArrayList<Place> shopPlaces = new ArrayList<>();
        shopPlaces.add(new Place("The Pike Outlets", "Long Beach, CA", "Mon - Sun", "10:00 AM - 9:00 PM",
                "Located in downtown Long Beach, The Pike Outlets is a vibrant dining and entertainment district linking the Long Beach Convention Center to Rainbow Harbor's waterfront and the Aquarium of the Pacific.", "95 S Pine Ave, Long Beach, CA 90802","\n" +
                "(877) 225-5337", 33.7648391, -118.1956316 ,R.drawable.the_pike_outlets));
        shopPlaces.add(new Place("Del Amo Fashion Cente", "Torrance, CA", "Mon - Sun", "10:00 AM - 9:00 PM",
                "Del Amo Fashion Center is a three-level regional luxury shopping mall in Torrance, California, United States. It is currently managed and co-owned by Simon Property Group.\n" +
                        "\n" +
                        "With a gross leasable area (GLA) of 2,500,000 sq ft (230,000 m2), it is the Third largest shopping malls in the United States. " +
                        "The mall features a food court, several anchor stores, including two Macy's locations, Nordstrom, JCPenney and Sears, a supermarket Mitsuwa Marketplace, 255 retailers, multiple full-service restaurants, a fitness center, and an AMC Theatres multiplex.",
                "3525 W Carson St, Torrance, CA 90503", "(310) 542-8525",33.8305609, -118.3517577,
                R.drawable.del_amo_mall));

        shopPlaces.add(new Place("Riviera Village", "Redondo Beach, CA", "Mon - Sun", "10:00 AM - 9:00 PM",
                "Welcome to the famous Riviera Village in Redondo Beach, CA. " +
                        "Nestled along the Pacific Ocean just 20 miles Southwest of Los Angeles and minutes from LAX, the Village offers over 300 one-of-a-kind boutiques, restaurants, galleries, salons and services. " +
                        "Come discover for yourself why it’s the quintessential So Cal beach town.", "1799 S Catalina Ave, Redondo Beach, CA 90277", "(424) 260-8386", 33.8171711, -118.3899283,  R.drawable.riviera_village));
        shopPlaces.add(new Place("South Bay Galleria", "Redondo Beach, CA", "Mon - Sun", "11:00 AM - 8:00 PM",
                "South Bay Galleria, formerly named Galleria at South Bay, is a shopping mall in Redondo Beach in Los Angeles County, California." +
                        " It is anchored by Macy's, Kohl's and Wonder of Dinosaurs, as well as a 16-screen AMC Theatres multiplex.", "1815 Hawthorne Blvd, Redondo Beach, CA 90278", "(310) 371-7546", 33.8710115, -118.3572153, R.drawable.southbay_galleria));

        ListAdapter adapter = new ListAdapter(getActivity(), shopPlaces);

        listView = view.findViewById(R.id.eatListView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = shopPlaces.get(position);
                callback.onFragmentInteraction(place);
            }
        });

        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setOnFragmentInteractionListener(DoFragment.OnFragmentInteractionListener callback) {
        this.callback = callback;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Place place);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof DoFragment.OnFragmentInteractionListener){
            onFragmentInteractionListener = (DoFragment.OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }
}
