package com.example.hannah.machinelearn.WorldThreeCollectTurnip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hannah.machinelearn.R;

public class Three_BadTurnipTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__bad_turnip_two);
    }

    public void goBack(View view){
        this.finish();
    }
}
