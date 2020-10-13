package com.example.musicalstructureapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlayingActivity extends AppCompatActivity {

    private int m = 0, current_postion;
    private String url;
    private ArrayList<Songs> list_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.now_playing);
        final TextView artist = findViewById (R.id.artist_name_playing);
        final TextView songName = findViewById (R.id.song_name);
        final TextView duration = findViewById (R.id.duration);
        ImageButton back = findViewById (R.id.back_to_list);
        Bundle bundle = getIntent ().getExtras ();
        assert bundle != null;
        artist.setText (bundle.getString ("artist"));
        songName.setText (bundle.getString ("name"));
        duration.setText (bundle.getString ("duration"));
        list_songs = bundle.getParcelableArrayList ("list");
        current_postion = Integer.parseInt (bundle.getString ("position"));
        back.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                onBackPressed ();
            }
        });
        final ImageView center_image = findViewById (R.id.center_image);
        final ImageView pause_play = findViewById (R.id.play_pause_btn);
        pause_play.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (m == 1) {
                    pause_play.setImageResource (R.drawable.ic_pause_button);
                    m = 0;
                } else if (m == 0) {
                    pause_play.setImageResource (R.drawable.ic_play_button);
                    m = 1;
                }
            }
        });
        url = bundle.getString ("url");
        Glide.with (getApplicationContext ()).asBitmap ().load (url).into (center_image);

        ImageView next = findViewById (R.id.btn_next);
        ImageView previous = findViewById (R.id.btn_previous);
        next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (current_postion == list_songs.size () - 1) {
                    Toast.makeText (PlayingActivity.this, "Last Song!", Toast.LENGTH_SHORT).show ();
                } else {
                    current_postion += 1;
                    artist.setText (list_songs.get (current_postion).getmArtist ());
                    songName.setText (list_songs.get (current_postion).getmSong_name ());
                    duration.setText (list_songs.get (current_postion).getmDuration ());
                    url = list_songs.get (current_postion).getmImageUrl ();
                    Glide.with (getApplicationContext ()).asBitmap ().load (url).into (center_image);
                }
            }
        });

        previous.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (current_postion == 0) {
                    Toast.makeText (getApplicationContext (), "First Song!", Toast.LENGTH_SHORT).show ();
                } else {
                    current_postion -= 1;
                    artist.setText (list_songs.get (current_postion).getmArtist ());
                    songName.setText (list_songs.get (current_postion).getmSong_name ());
                    duration.setText (list_songs.get (current_postion).getmDuration ());
                    url = list_songs.get (current_postion).getmImageUrl ();
                    Glide.with (getApplicationContext ()).asBitmap ().load (url).into (center_image);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed ();
    }
}