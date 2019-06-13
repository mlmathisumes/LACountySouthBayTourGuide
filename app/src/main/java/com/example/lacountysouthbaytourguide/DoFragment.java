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
 * This fragment shows a listview of places to do activities at in the southbay
 *
 */

public class DoFragment extends Fragment {

    private ListView listView;
    private OnFragmentInteractionListener callback;
    private OnFragmentInteractionListener onFragmentInteractionListener;


    public DoFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatfragment, container, false);

        final ArrayList<Place> doPlaces = new ArrayList<>();
        doPlaces.add(new Place("The Skating Edge Ice Arena", "Harbor City, CA", "Mon - Sat", "3:00 PM - 5:00 PM",
                "Enclosed ice arena with public skate times & lessons, hockey leagues, broomball & a snack bar.", "23770 S Western Ave, Harbor City, CA 90710","(310) 325-4474", 33.8092774, -118.3098507 , R.drawable.ice_arena));

        doPlaces.add(new Place("K1 Speed", "Gardena, CA", "Mon - Sat", "12:00 PM - 10:00 PM",
                "\n" +
                        "K1 Speed offers a fun, exciting thing to do in Gardena, CA. K1 Speed delivers an unforgettable experience for friends, families, and businesses. " +
                        "Each location features fast electric go karts, a professionally-designed track, state-of-the-art safety barriers, private meeting rooms, an arcade, and an onsite eatery that offers food and drinks. " +
                        "This makes K1 Speed the best entertainment venue in the area, and a great idea for family fun, social outings, team building, corporate events, company parties, birthday parties, bachelor(ette) parties, and more.",
                "19038 S Vermont Ave, Gardena, CA 90248", "(310) 532-2478", 33.8574932, -118.2910341, R.drawable.k1_speed));


        ListAdapter adapter = new ListAdapter(getActivity(), doPlaces);

        listView = view.findViewById(R.id.eatListView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = doPlaces.get(position);
                callback.onFragmentInteraction(place);
            }
        });
        return  view;
    }

    public void setOnFragmentInteractionListener(OnFragmentInteractionListener callback) {
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
        if(context instanceof  OnFragmentInteractionListener){
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
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
