package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hannah.machinelearn.R;

public class Two_WorldTwo extends AppCompatActivity {

    //egg buttons
    ImageButton egg1;
    ImageButton egg2;
    ImageButton egg3;
    ImageButton egg4;
    ImageButton egg5;
    ImageButton egg6;
    ImageButton egg7;
    ImageButton egg8;
    ImageButton egg9;
    ImageButton egg10;
    ImageButton egg11;
    ImageButton egg12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_world_two);

        setOnClickListeners();
    }

    public void setOnClickListeners(){

        //egg good
        egg1 = (ImageButton) findViewById(R.id.egg1);
        egg1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_GoodEgg.class);
                startActivity(intent);
                egg1.setVisibility(View.INVISIBLE);
                finish();
            }
        });

        //egg smashed
        egg2 = (ImageButton) findViewById(R.id.egg2);
        egg2.setOnClickListener(new EggListener(egg2));

        //egg smashed
        egg3 = (ImageButton) findViewById(R.id.egg3);
        egg3.setOnClickListener(new EggListener(egg3));

        //egg smashed
        egg4 = (ImageButton) findViewById(R.id.egg4);
        egg4.setOnClickListener(new EggListener(egg4));

        //egg smashed
        egg5 = (ImageButton) findViewById(R.id.egg5);
        egg5.setOnClickListener(new EggListener(egg5));

        //egg smashed
        egg6 = (ImageButton) findViewById(R.id.egg6);
        egg6.setOnClickListener(new EggListener(egg6));


        //egg smashed
        egg7 = (ImageButton) findViewById(R.id.egg7);
        egg7.setOnClickListener(new EggListener(egg7));

        //egg smashed
        egg8 = (ImageButton) findViewById(R.id.egg8);
        egg8.setOnClickListener(new EggListener(egg8));

        //egg smashed
        egg9 = (ImageButton) findViewById(R.id.egg9);
        egg9.setOnClickListener(new EggListener(egg9));

        //egg smashed
        egg10 = (ImageButton) findViewById(R.id.egg10);
        egg10.setOnClickListener(new EggListener(egg10));

        //egg smashed
        egg11 = (ImageButton) findViewById(R.id.egg11);
        egg11.setOnClickListener(new EggListener(egg11));

        //egg smashed
        egg12 = (ImageButton) findViewById(R.id.egg12);
        egg12.setOnClickListener(new EggListener(egg12));
    }

    public void changeActivity(View view) {
        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Back")) {
            this.finish();
        }
        if (buttonText.equals("Rules")) {
            Intent intent = new Intent(getApplicationContext(), Two_Rules.class);
            startActivity(intent);
        }
    }


    class EggListener implements View.OnClickListener {

        ImageButton egg;

        public EggListener(ImageButton egg){

            this.egg = egg;
        }

        @Override
        public void onClick(View v) {
            eggClicked(egg);
        }
    }

    private void eggClicked(ImageButton egg) {

        Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
        startActivity(intent);
        egg.setVisibility(View.INVISIBLE);

    }

}
