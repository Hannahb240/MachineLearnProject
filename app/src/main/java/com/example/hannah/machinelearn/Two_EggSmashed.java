package com.example.hannah.machinelearn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Two_EggSmashed extends AppCompatActivity {

    TextView eggSmashedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__egg_smashed);

        ImageView img= (ImageView) findViewById(R.id.smashedEgg);
        img.setImageResource(R.drawable.crackedegg);

        eggSmashedText = (TextView) findViewById(R.id.eggsmashedtext);
        eggSmashedText.setTextColor(Color.parseColor("#000000"));
    }

    public void returnToWorldTwo(View view) {
        this.finish();
    }
}
