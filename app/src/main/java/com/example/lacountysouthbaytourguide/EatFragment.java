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
 * This fragment shows a listview of places to eat at in the southbay
 *
 */

public class EatFragment extends Fragment {
    private DoFragment.OnFragmentInteractionListener callback;
    private DoFragment.OnFragmentInteractionListener onFragmentInteractionListener;
    private ListView listView;

    public EatFragment(){
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatfragment, container, false);

        final ArrayList<Place> eatPlaces = new ArrayList<>();
        eatPlaces.add(new Place("The Grail Churros &amp; Ice Cream", "Redondo Beach, CA", "Mon - Sun", "8:00 AM - 5:00 PM",
                "Churros &amp; Ice Cream &amp; Vibes. Offers a variety of delicious desserts from homemade ice cream to Churro ice cream sandwiches.",
                "1808 S Pacific Coast Hwy, Redondo Beach, CA 90277", "480-330-8114", 33.8170088, -118.3825219 , R.drawable.grail_churros ));

        eatPlaces.add(new Place("Hermosa Beach Fish Shop", "Hermosa Beach, CA", "Mon - Sun", "11:00 AM - 9:00 PM",
                "The Fish Shop first dropped anchor in Pacific Beach in 2010. Since then, we’ve built a reputation for providing our customers with the freshest seafood, complimented with outstanding service in " +
                        "a relaxed atmosphere that is both family- and dog-friendly.", "719 Pier Ave, Hermosa Beach, CA 90254", "310-372-3480", 33.865092, -118.3961588
                        , R.drawable.hermosa_fish_shop));

        eatPlaces.add(new Place("Grimaldi's Pizzeria", "El Segundo", "Mon - Sun", "11:00 AM - 10:00 PM",
                "Casual, Brooklyn-based pizzeria chain serving brick-oven pies & calzones plus wine & beer.",
                "2121 Rosecrans Ave #1399, El Segundo, CA 90245", "(310) 648-7503", 33.9021633, -118.3893649,  R.drawable.grimaldi_pizzeria));


        ListAdapter adapter = new ListAdapter(getActivity(), eatPlaces);

        listView = view.findViewById(R.id.eatListView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = eatPlaces.get(position);
                callback.onFragmentInteraction(place);
            }
        });
        return  view;

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
