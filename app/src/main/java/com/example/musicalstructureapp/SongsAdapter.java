package com.example.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class SongsAdapter extends ArrayAdapter<Songs> {
    private static final String LOG_TAG = SongsAdapter.class.getSimpleName ();

    public SongsAdapter(@NonNull Activity context, @NonNull ArrayList<Songs> songs) {
        super (context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate (R.layout.list_item, parent, false);
        }

        Songs currentSong = getItem (position);

        ImageView imageView = listItemView.findViewById (R.id.music_image);
        Glide.with (getContext ()).asBitmap ().load (currentSong.getmImageUrl ()).into (imageView);

        TextView song = listItemView.findViewById (R.id.name_of_song);
        song.setText(currentSong.getmSong_name());

        TextView duration = listItemView.findViewById (R.id.song_length);
        duration.setText(currentSong.getmDuration());

        TextView artist = listItemView.findViewById (R.id.artist);
        artist.setText(currentSong.getmArtist());

        return listItemView;
    }
}
