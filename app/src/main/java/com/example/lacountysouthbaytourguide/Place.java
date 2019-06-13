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

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private String name;
    private String city;
    private String openingDay;
    private String openingTime;
    private String description;
    private static int id = 0;
    private String address;
    private String phoneNumber;
    private double latitude;
    private double longitude;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;



    public Place(String name, String city, String openingDay, String openingTime, String description,
                 String address, String phoneNumber, double latitude, double longitude, int mImageResourceId){
        this.name = name;
        this.city = city;
        this.openingDay = openingDay;
        this.openingTime = openingTime;
        this.description = description;
        this.mImageResourceId = mImageResourceId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;

        id++;
    }

    protected Place(Parcel in) {
        name = in.readString();
        city = in.readString();
        openingDay = in.readString();
        openingTime = in.readString();
        description = in.readString();
        mImageResourceId = in.readInt();
        address = in.readString();
        phoneNumber = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();

    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getOpeningDay() {
        return openingDay;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getDescription() {
        return description;
    }

    public static int getId() {
        return id;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(openingDay);
        dest.writeString(openingTime);
        dest.writeString(description);
        dest.writeInt(mImageResourceId);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
