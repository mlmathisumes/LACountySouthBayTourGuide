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
 * This fragment shows a listview of places to see in the southbay
 *
 */

public class SeeFragment extends Fragment{

    private DoFragment.OnFragmentInteractionListener callback;
    private DoFragment.OnFragmentInteractionListener onFragmentInteractionListener;
    ListView listView;


    public SeeFragment(){
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eatfragment, container, false);

        final ArrayList<Place> seePlaces = new ArrayList<>();
        seePlaces.add(new Place("Lomita Railroad Museum", "Lomita, CA", "Thurs - Sun", "10:00 AM - 5:00 PM",
                "The Lomita Railroad Museum is a museum in Lomita, California devoted to California railroad history during the steam era.\n" +
                        "\n" +
                        "It was founded by Irene Lewis in the early 1960s on a single lot in the middle of a residential part of Lomita, and opened in 1966. " +
                        "The museum building is a replica of a 19th-century depot that once stood in Wakefield, Massachusetts, and there is a full size replica of a water tower. " +
                        "The museum grounds now function as a small public park.","2137 250th St, Lomita, CA 90717",
                "(310) 326-6255",33.7984108, -118.3209206,  R.drawable.train_museum));

        seePlaces.add(new Place("Laugh Factory", "Long Beach, CA", "Wed - Sun", "10:00 AM - 9:45 PM",
                "Opening its doors in 1979, the World Famous Laugh Factory has been recognized as \"the #1 comedy club in the country\" by such high-profile media as USA Today. " +
                        "With southern California locations in Hollywood (its original Sunset Boulevard locale) and Long Beach (opened in 2008), comedy's top stars, as well as today's brightest emerging talent, shine on its legendary stage.",
                "151 S Pine Ave, Long Beach, CA 90802",
                "(562) 495-2844", 33.7638094, -118.1948957, R.drawable.laugh_factory));

        ListAdapter adapter = new ListAdapter(getActivity(), seePlaces);

        listView = view.findViewById(R.id.eatListView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = seePlaces.get(position);
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
