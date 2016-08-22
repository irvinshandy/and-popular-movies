package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by IrvinShandy on 8/20/16.
 */
public class Movie implements Parcelable {
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };
    private String mTitle;
    private String mOverview;
    private double mUserRating;
    private String mReleaseDate;
    private String mImageUrl;

    public Movie(String title, String overview, double userRating, String releaseDate, String imageUrl) {
        mTitle = title;
        mOverview = overview;
        mUserRating = userRating;
        mReleaseDate = releaseDate;
        mImageUrl = imageUrl;
    }

    private Movie(Parcel in) {
        mTitle = in.readString();
        mOverview = in.readString();
        mUserRating = in.readDouble();
        mReleaseDate = in.readString();
        mImageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mOverview);
        parcel.writeDouble(mUserRating);
        parcel.writeString(mReleaseDate);
        parcel.writeString(mImageUrl);
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public double getUserRating() {
        return mUserRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
