package com.example.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        TextView songs = findViewById (R.id.tvSongs);
        songs.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent (MainActivity.this, SongsActivity.class);
                startActivity (songsIntent);
            }
        });
    }
}