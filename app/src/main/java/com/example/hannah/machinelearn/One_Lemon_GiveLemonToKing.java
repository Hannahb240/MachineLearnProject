package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_Lemon_GiveLemonToKing extends AppCompatActivity {

    TextView text;
    TextView text2;

    ImageView lemonPic;
    Button goToWorld2;
    Button nextButton;

    TextView texxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_give_lemon_to_king);

        text = (TextView) findViewById(R.id.text);
        text.setTextSize(20);
        text2 = (TextView) findViewById(R.id.text2);
        text2.setTextSize(20);

        text.setText("Well done! You've collected a lemon. The next task is to find an egg, tap next to go to the next world.");
        text.setTextColor(Color.parseColor("#000000"));
        text.setTextSize(20);

        lemonPic = (ImageView) findViewById(R.id.lemon);
        lemonPic.setImageResource(R.drawable.lemon);

        goToWorld2 = (Button) findViewById(R.id.worldtwo);
        goToWorld2.setVisibility(View.INVISIBLE);

        nextButton = (Button) findViewById(R.id.next);
    }

//    public void next(View view){
//        text2.setText("Tap the button below to go to the next world where you'll search for the eggs.");
//        goToWorld2.setVisibility(View.VISIBLE);
//        nextButton.setVisibility(View.INVISIBLE);
//    }

    public void worldTwo(View view){
        Intent intent = new Intent(getApplicationContext(), Two_WorldTwo.class);
        startActivity(intent);
        this.finish();
    }
}
