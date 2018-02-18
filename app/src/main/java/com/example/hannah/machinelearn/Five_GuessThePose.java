package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Five_GuessThePose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_the_pose);

    }

    public void tryToGuessPose(View view){
        Intent intent = new Intent(getApplicationContext(), Five_GuessPoseButtons.class);
        startActivity(intent);
    }
}
