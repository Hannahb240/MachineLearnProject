package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Three_WorldThree extends AppCompatActivity {


    ImageButton turnip1;
    ImageButton turnip2;

    ImageButton turnip3;
    ImageButton turnip4;

    ImageButton turnip5;
    ImageButton turnip6;

    ImageButton turnip7;
    ImageButton turnip8;

    ImageButton turnip9;
    ImageButton turnip10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__world_three);

        //Good turnip
        turnip1 = (ImageButton) findViewById(R.id.turnip1);
        turnip1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_GoodTurnipOne.class);
                startActivity(intent);
                turnip1.setVisibility(View.INVISIBLE);
            }
        });

        //Good turnip
        turnip2 = (ImageButton) findViewById(R.id.turnip2);
        turnip2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipOne.class);
                startActivity(intent);
                turnip2.setVisibility(View.INVISIBLE);
            }
        });

        //Good turnip
        turnip3 = (ImageButton) findViewById(R.id.turnip3);
        turnip3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipOne.class);
                startActivity(intent);
                turnip3.setVisibility(View.INVISIBLE);
            }
        });

        turnip4 = (ImageButton) findViewById(R.id.turnip4);
        turnip4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipOne.class);
                startActivity(intent);
                turnip4.setVisibility(View.INVISIBLE);
            }
        });

        turnip5 = (ImageButton) findViewById(R.id.turnip5);
        turnip5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipOne.class);
                startActivity(intent);
                turnip5.setVisibility(View.INVISIBLE);
            }
        });

        turnip6 = (ImageButton) findViewById(R.id.turnip6);
        turnip6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipTwo.class);
                startActivity(intent);
                turnip6.setVisibility(View.INVISIBLE);
            }
        });

        turnip7 = (ImageButton) findViewById(R.id.turnip7);
        turnip7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipTwo.class);
                startActivity(intent);
                turnip7.setVisibility(View.INVISIBLE);
            }
        });

        turnip8 = (ImageButton) findViewById(R.id.turnip8);
        turnip8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipTwo.class);
                startActivity(intent);
                turnip8.setVisibility(View.INVISIBLE);
            }
        });

        turnip9 = (ImageButton) findViewById(R.id.turnip9);
        turnip9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipTwo.class);
                startActivity(intent);
                turnip9.setVisibility(View.INVISIBLE);
            }
        });

        turnip10 = (ImageButton) findViewById(R.id.turnip10);
        turnip10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Three_BadTurnipTwo.class);
                startActivity(intent);
                turnip10.setVisibility(View.INVISIBLE);
            }
        });



    }
}
