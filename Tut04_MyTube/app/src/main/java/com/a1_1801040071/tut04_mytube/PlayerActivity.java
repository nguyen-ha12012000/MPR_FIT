package com.a1_1801040071.tut04_mytube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //retrieve link to video to PlayerActivity
        Intent intent = getIntent();
        String link = intent.getStringExtra("LINK");

        //for testing
//        TextView tvLink = findViewById(R.id.tvLink);
//        tvLink.setText(link);

        //init player
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(link);


        //control the video
        videoView.setMediaController(new MediaController(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("onPause-PLAYBACK", videoView.getCurrentPosition()+"");

        //store the current playback position
        position = videoView.getCurrentPosition();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("onStop-PLAYBACK", videoView.getCurrentPosition()+"");
        videoView.stopPlayback();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //save current playback position
        Log.d("onSaveInstanceState", videoView.getCurrentPosition() + "");

        outState.putInt("PLAYBACK",this.position);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //restore current playback position
        videoView.seekTo(savedInstanceState.getInt("PLAYBACK"));
    }
}