package com.davissylvester.musicalstructuralappjava.DomainClasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Artist implements Parcelable {

    public String FirstName;
    public String LastName;
    public String Photo;
    public String StageName;

    public Artist(String fName, String lName, String photo, String stageName) {

        this.FirstName = fName;
        this.LastName = lName;
        this.Photo = photo;
        this.StageName = stageName;

    }

    protected Artist(Parcel in) {
        FirstName = in.readString();
        LastName = in.readString();
        Photo = in.readString();
        StageName = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(FirstName);
        dest.writeString(LastName);
        dest.writeString(Photo);
        dest.writeString(StageName);

    }
}
