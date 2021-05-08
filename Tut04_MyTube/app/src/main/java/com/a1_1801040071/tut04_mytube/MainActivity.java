package com.a1_1801040071.tut04_mytube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get ref to edit Text
        EditText editLink = findViewById(R.id.editLink);

        //get ref to ,my button
        ImageButton btnPlay = findViewById(R.id.btnPlay);

        // handle click event
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get entered value
                String link = editLink.getText().toString();

                //for testing
                //Toast.makeText(MainActivity.this, link, Toast.LENGTH_SHORT).show();

                //start PlayerActivity
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
//
//                //pass video link to PlayerActivity
                intent.putExtra("LINK", link);
                startActivity(intent);
            }
        });
    }
}