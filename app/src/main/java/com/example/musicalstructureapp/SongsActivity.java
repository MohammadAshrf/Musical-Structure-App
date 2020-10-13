package com.example.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    public SongsActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_songs);


        final ArrayList<Songs> songs = new ArrayList<> ();
        songs.add (new Songs ("Ohebbou Yadayka", "Faia Younan", "3:47", "https://i.pinimg.com/originals/f8/48/ad/f848adb594bd03a742c5c4c3a26427df.jpg"));
        songs.add (new Songs ("I Only Wanna Be with You", "Dusty", "2:43", "https://img.youtube.com/vi/osVaF4t-zFc/hqdefault.jpg"));
        songs.add (new Songs ("Let's Fall in Love for the Night", "FINNEAS", "3:10", "https://i.ytimg.com/vi/NSl6jd0r9Vk/maxresdefault.jpg"));
        songs.add (new Songs ("Be Alright", "Dean Lewis", "3:16", "https://m.media-amazon.com/images/I/71a6LwaEmuL._SS500_.jpg"));
        songs.add (new Songs ("Bank Account", "21 Savage", "3:40", "https://i.ytimg.com/vi/sV2t3tW_JTQ/maxresdefault.jpg"));
        songs.add (new Songs ("Yemken", "Fairuz", "3:08", "https://i.ytimg.com/vi/RQOwE4V1f68/mqdefault.jpg"));
        songs.add (new Songs ("Agmal Eyoun", "Amr Diab", "3:39", "https://i.ytimg.com/vi/HcodxmdesfY/maxresdefault.jpg"));
        songs.add (new Songs ("Tokaa We Tkoom", "Massar Egbari", "4:38", "https://mediaaws.almasryalyoum.com/news/large/2020/07/19/1268680_0.png"));
        songs.add (new Songs ("Lost on You", "LP", "4:28", "https://images-na.ssl-images-amazon.com/images/I/51lvHe08tNL.jpg"));
        songs.add (new Songs ("Radioactive", "Imagine Dragons", "3:06", "https://images-na.ssl-images-amazon.com/images/I/71SrRo5Mg6L._SL1057_.jpg"));


        // Create an {@link songsAdapter}, whose data source is a list of
        // {@link songs}s. The adapter knows how to create list item views for each item
        // in the list.
        SongsAdapter songsAdapter = new SongsAdapter (this, songs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = findViewById (R.id.songsListView);
        listView.setAdapter (songsAdapter);

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song_name = songs.get (position).getmSong_name ();
                String artist = songs.get (position).getmArtist ();
                String duration = songs.get (position).getmDuration ();
                Intent intent = new Intent (SongsActivity.this, PlayingActivity.class);
                Bundle bundle = new Bundle ();
                bundle.putString ("name", song_name);
                bundle.putString ("artist", artist);
                bundle.putString ("duration", duration);
                String url = songs.get (position).getmImageUrl ();
                bundle.putString ("url", url);
                bundle.putParcelableArrayList ("list", songs);
                String position_of_item = "" + position;
                bundle.putString ("position", position_of_item);
                intent.putExtras (bundle);
                startActivity (intent);
            }


        });

    }


}