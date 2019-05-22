package com.example.hannah.machinelearn.WorldOneCollectLemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.WorldTwoCollectEgg.Two_WorldTwo;
import com.example.hannah.machinelearn.Utils;

public class One_Lemon_GiveLemonToKing extends AppCompatActivity {

    TextView instructions;

    ImageView lemonPic;
    Button goToWorld2Button;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_give_lemon_to_king);

        goToWorld2Button = (Button) findViewById(R.id.worldtwo);
        nextButton = (Button) findViewById(R.id.next);

        lemonPic = (ImageView) findViewById(R.id.lemon);
        lemonPic.setImageResource(R.drawable.lemon);

        instructions = (TextView) findViewById(R.id.text);
        Utils.setInstructions(instructions, "Well done! You've collected a lemon. The next task is to find an egg, tap next to go to the next world.");

        goToWorld2Button.setVisibility(View.INVISIBLE);

    }

    public void worldTwo(View view){
        Intent intent = new Intent(getApplicationContext(), Two_WorldTwo.class);
        startActivity(intent);
        this.finish();
    }
}
