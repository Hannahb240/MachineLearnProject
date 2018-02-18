package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Five_GuessPoseButtons extends AppCompatActivity {

    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;
    ImageButton button5;
    ImageButton button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_pose_buttons);

        button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_StandingPose.class);
                startActivity(intent);
                button1.setVisibility(View.INVISIBLE);
            }
        });

        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_CrouchingPose.class);
                startActivity(intent);
                button2.setVisibility(View.INVISIBLE);
            }
        });

        button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_LyingDownPose.class);
                startActivity(intent);
                button3.setVisibility(View.INVISIBLE);
            }
        });

        button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_StandingPose.class);
                startActivity(intent);
                button4.setVisibility(View.INVISIBLE);
            }
        });

        button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_CrouchingPose.class);
                startActivity(intent);
                button5.setVisibility(View.INVISIBLE);
            }
        });

        button6 = (ImageButton) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Five_LyingDownPose.class);
                startActivity(intent);
                button6.setVisibility(View.INVISIBLE);
            }
        });
    }
}
