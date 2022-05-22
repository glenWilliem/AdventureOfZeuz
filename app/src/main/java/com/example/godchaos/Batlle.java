package com.example.godchaos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Batlle extends AppCompatActivity {

    Random generator;
    TextView tv_playerHp ,tv_enemyHp;
    ImageView enemyAttack;
    ImageButton Rock,Paper,Scisors,volume;
    int playerHp,enemyHp = 100;
    boolean musicOn;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batlle);

        playerHp =100;
        enemyHp = 100;

        getSupportActionBar().hide();

        initialize();

        MediaPlayer bgm = MediaPlayer.create(Batlle.this,R.raw.battle_bgm);
        bgm.start();

        selectAttack();


        musicOn=true;
        volume.setOnClickListener(view -> {
            if (musicOn==true){
                bgm.pause();
                musicOn=false;
            }
            else if(musicOn==false){
                bgm.start();
                musicOn=true;
            }
        });



    }

    private void battleDone() {
        if (playerHp <= 0 ) {
            Intent end = new Intent(Batlle.this, EndScreen.class);
            startActivity(end);
        }else
            if (enemyHp <= 0){
                Intent end = new Intent(Batlle.this, EndScreen.class);
                startActivity(end);
            }
    }


    private void selectAttack() {
        Rock.setOnClickListener(view -> {
           String message = enemyAttack("rock");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            tv_playerHp.setText(Integer.toString(playerHp));
            tv_enemyHp.setText(Integer.toString(enemyHp));
            battleDone();
        });
            Scisors.setOnClickListener(view1 -> {
               String message =  enemyAttack("scisors");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                tv_playerHp.setText(Integer.toString(playerHp));
                tv_enemyHp.setText(Integer.toString(enemyHp));
                battleDone();
        });

            Paper.setOnClickListener(view -> {
               String message = enemyAttack("paper");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                tv_playerHp.setText(Integer.toString(playerHp));
                tv_enemyHp.setText(Integer.toString(enemyHp));
                battleDone();
            });


    }

    private void initialize() {
        Rock = findViewById(R.id.btn_rock);
        Paper = findViewById(R.id.btn_paper);
        Scisors = findViewById(R.id.btn_scisors);
        volume = findViewById(R.id.volume);

        tv_playerHp = findViewById(R.id.playerHp);
        tv_enemyHp = findViewById(R.id.tv_enemyHp);
        enemyAttack = findViewById(R.id.enemyAttack);
    }

    public String enemyAttack(String playerAttack) {
        String comAttack = "";
        generator = new Random();
        int result = generator.nextInt(3);

        if (result == 0){
            comAttack = "scisors";
        }else
        if (result == 1){
            comAttack= "rock";
        }else
            if (result == 2){
                comAttack = "paper";
            }

        //SET IMAGE
        if (result==0){
            enemyAttack.setImageResource(R.drawable.scisors);
        }else
        if (result==1){
            enemyAttack.setImageResource(R.drawable.rock);
        }else
        if (result==2){
            enemyAttack.setImageResource(R.drawable.paper);
        }

        //Compare
        if (comAttack == playerAttack){
            return "Draw";
        }
        else if (playerAttack=="rock" && comAttack == "scisors"){
            enemyHp = enemyHp-20;
            return "Player Attacks with Thunder Bolt";
        }
        else if (playerAttack=="rock" && comAttack == "paper"){
            playerHp = playerHp-20;
            return "Enemy attack with Sword Thrust";
        }
        else if (playerAttack=="scisors" && comAttack == "paper"){
            enemyHp = enemyHp-30;
            return "Player Attacks with Lighting Struck";
        }
        else if (playerAttack=="scisors" && comAttack == "rock"){
            playerHp = playerHp-30;
            return "Enemy Attacks with Storm Hammer";
        }
        else if (playerAttack=="paper" && comAttack == "rock"){
            enemyHp = enemyHp-50;
            return "Player Attacks with Thundergod Wrath";
        }else if (playerAttack=="paper" && comAttack == "scisors"){
            playerHp = playerHp-30;
            return "Enemy Attacks with Great Cleave";
        }else return "null";


    }

}