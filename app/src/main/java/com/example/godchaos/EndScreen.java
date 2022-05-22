package com.example.godchaos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    TextView mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        getSupportActionBar().hide();

        MediaPlayer winSong = MediaPlayer.create(EndScreen.this,R.raw.shake);
        winSong.start();
        winSong.isLooping();


        mainMenu = findViewById(R.id.mainMenu);
        mainMenu.setOnClickListener(view -> {
            Intent mainMenu = new Intent(EndScreen.this,HomeScreen.class);
            startActivity(mainMenu);
        });

    }
}