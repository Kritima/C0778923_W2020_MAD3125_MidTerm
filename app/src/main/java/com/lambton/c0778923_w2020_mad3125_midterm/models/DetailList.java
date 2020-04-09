package com.lambton.c0778923_w2020_mad3125_midterm.models;

import android.os.Parcel;
import android.os.Parcelable;



public class DetailList  implements Parcelable {

    public static final Creator<DetailList> CREATOR = new Creator<DetailList>() {
        public DetailList createFromParcel(Parcel parcel) {
            return new DetailList(parcel);
        }

        public DetailList[] newArray(int i) {
            return new DetailList[i];
        }
    };

    private String name;
    private String value;

    public DetailList(String name, String value) {
        this.name = name;
        this.value = value;
    }

    protected DetailList(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.name);
        dest.writeString(this.value);

    }
}
