package com.example.labone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlaySongService extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song_service);

        Button buttonPlay = findViewById(R.id.play_btn);
        Button buttonStop = findViewById(R.id.stop_btn);

        buttonPlay.setOnClickListener(v -> playSong());
        buttonStop.setOnClickListener(v -> stopSong());

    }

    public void playSong()  {
        // Create Intent object for PlaySongService.
        Intent intent = new Intent(PlaySongService.this, ServiceActivity.class);

        // Call startService with Intent parameter.
        startService(intent);
    }

    // This method is called when users click on the Stop button.
    public void stopSong( )  {

        // Create Intent object
        Intent intent = new Intent(PlaySongService.this, ServiceActivity.class);
        stopService(intent);
    }
}