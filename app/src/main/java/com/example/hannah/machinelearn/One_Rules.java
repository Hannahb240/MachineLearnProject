package com.example.hannah.machinelearn;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class One_Rules extends AppCompatActivity {

    TextView rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__rules);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));

        rules = (TextView) findViewById(R.id.rules);
        rules.setText("You need to find the lemon tree! Tap on each tree until you find it.");
        rules.setTextSize(20);
    }

    public void goBack(View view){
        this.finish();
    }
}
