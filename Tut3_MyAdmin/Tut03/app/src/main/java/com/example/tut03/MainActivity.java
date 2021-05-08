package com.example.tut03;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView character;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set default display character
        character = findViewById(R.id.star);

        //spin
        Button btnSpin = findViewById(R.id.btnSpin);
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.animate().rotationBy(360*2).setDuration(1000);
            }
        });


        //jump
        Button btnJump = findViewById(R.id.btnJump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.animate().translationYBy(-200).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        character.animate().translationYBy(200).setDuration(1000);
                    }
                });
            }
        });

        //clap
        Button btnClap = findViewById(R.id.btnClap);
        btnClap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.clapping);
                mediaPlayer.start();
            }
        });
    }



    public void onCharacterClick(View view) {
        if (view == findViewById(R.id.btnStar)) {       //click on button ballStar
            character = findViewById(R.id.star);

            findViewById(R.id.star).animate().alpha(1).setDuration(1000); //star is displayed in 1000
            findViewById(R.id.ball).animate().alpha(0).setDuration(1000); // ball is disappear in 1000
        }else if (view == findViewById(R.id.btnBall)) {
            character = findViewById(R.id.ball);

            findViewById(R.id.ball).animate().alpha(1).setDuration(1000);
            findViewById(R.id.star).animate().alpha(0).setDuration(1000);
        }

    }


}