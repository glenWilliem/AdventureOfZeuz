package com.example.godchaos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    ImageButton btn_play,volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        volume = findViewById(R.id.volume_on);
        volume.setOnClickListener(view -> {
            MediaPlayer audio1 = MediaPlayer.create(HomeScreen.this,R.raw.god_is_good);
            Toast.makeText(HomeScreen.this,"EXCERCISE PURPOSE ONLY",Toast.LENGTH_LONG).show();
            audio1.start();
        });

        btn_play = findViewById(R.id.play_button);

        btn_play.setOnClickListener(view -> { Intent intent = new Intent(this,LoadingScreen.class);
        startActivity(intent);
        });

    }
}