package com.example.tut02_ex2_log_me_in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void onBtnClick(View view) {
        //get reference username
        EditText username = findViewById(R.id.inputName);
        //get username
        String text = username.getText().toString();
        //get reference password
        EditText password = findViewById(R.id.inputTextPassword);
        //get password
        String pw = password.getText().toString();

        if (text.equals("nganha")) {
            if(pw.equals("ha123")) {
                Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Password is false!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(MainActivity.this, "Username is invalid!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}