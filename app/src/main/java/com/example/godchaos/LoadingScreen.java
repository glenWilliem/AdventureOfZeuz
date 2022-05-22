package com.example.godchaos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoadingScreen extends AppCompatActivity {

    TextView cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        getSupportActionBar().hide();

        cont = findViewById(R.id.cont);
        cont.setOnClickListener(view -> {
            Intent go = new Intent(LoadingScreen.this,Batlle.class);
            startActivity(go);
        });

    }
}