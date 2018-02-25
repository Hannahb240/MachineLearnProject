package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Five_GuessPoseButtons extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_pose_buttons);
    }

    public void goToGuessPose(View view){
        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        startActivity(intent);
        this.finish();
    }
}

