package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Two_GiveEggToComputer extends AppCompatActivity {

    TextView instructions;

    ImageView eggPic;
    Button goBack;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__give_egg_to_computer);

        goBack = (Button) findViewById(R.id.worldtwo);
        nextButton = (Button) findViewById(R.id.next);
        eggPic = (ImageView) findViewById(R.id.eggView);

        instructions = (TextView) findViewById(R.id.text);
        Utils.setInstructions(instructions, "Well done! You've collected an egg. Tap finish to end the game.");

        eggPic.setImageResource(R.drawable.egg);
        goBack.setVisibility(View.INVISIBLE);

    }

    public void worldTwo(View view){

        this.finish();
    }
}
