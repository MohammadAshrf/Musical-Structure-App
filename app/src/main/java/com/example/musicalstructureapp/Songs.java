package com.example.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Songs implements Parcelable {

    private String mSong_name;
    private String mArtist;
    private String mDuration;
    private String mImageUrl;

    public Songs(String mSong_name, String mArtist, String mDuration, String mImageUrl) {
        this.mSong_name = mSong_name;
        this.mArtist = mArtist;
        this.mDuration = mDuration;
        this.mImageUrl = mImageUrl;
    }

    protected Songs(Parcel in) {
        mSong_name = in.readString ();
        mArtist = in.readString ();
        mDuration = in.readString ();
        mImageUrl = in.readString ();
    }

    public static final Creator<Songs> CREATOR = new Creator<Songs> () {
        @Override
        public Songs createFromParcel(Parcel in) {
            return new Songs (in);
        }

        @Override
        public Songs[] newArray(int size) {
            return new Songs[size];
        }
    };

    public String getmSong_name() {
        return mSong_name;
    }

    public String getmArtist() {
        return mArtist;
    }

    public String getmDuration() {
        return mDuration;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (mSong_name);
        dest.writeString (mArtist);
        dest.writeString (mDuration);
        dest.writeString (mImageUrl);
    }
}
