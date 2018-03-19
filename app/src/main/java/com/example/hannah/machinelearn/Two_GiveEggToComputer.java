package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Two_GiveEggToComputer extends AppCompatActivity {

    TextView text;
    TextView text2;

    ImageView eggPic;
    Button goBack;
    Button nextButton;

    int foundEggs;

    TextView texxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__give_egg_to_computer);

        Bundle b = getIntent().getExtras();
        foundEggs = b.getInt("key");

        text = (TextView) findViewById(R.id.text);
        text.setTextSize(20);
        text2 = (TextView) findViewById(R.id.text);
        text2.setTextSize(20);

        text.setText("Well done! You've collected an egg. Tap finish to end the game.");

        eggPic = (ImageView) findViewById(R.id.eggView);
        eggPic.setImageResource(R.drawable.egg);

        goBack = (Button) findViewById(R.id.worldtwo);
        goBack.setVisibility(View.INVISIBLE);

        nextButton = (Button) findViewById(R.id.next);


    }

//    public void next(View view){
//        if(foundEggs == 1){
//            text2.setText("Tap the button below to go to back and find one more egg.");
//            goBack.setVisibility(View.VISIBLE);
//            nextButton.setVisibility(View.INVISIBLE);
//        }
//        else if(foundEggs == 2){
//            text2.setText("You've found both eggs, tap the button below to finish the game.");
//            goBack.setVisibility(View.VISIBLE);
//            nextButton.setVisibility(View.INVISIBLE);
//            goBack.setText("Finish");
//        }
//    }

    public void worldTwo(View view){
        this.finish();
    }
}
