package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Two_Rules extends AppCompatActivity {

    TextView rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__rules);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.6));

        rules = (TextView) findViewById(R.id.rules);
        Utils.setInstructions(rules,"You need to find an egg which is not cracked! Tap on each egg until you find it.");

    }

    public void goBack(View view){
        this.finish();
    }
}
