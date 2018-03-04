package com.example.hannah.machinelearn;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Two_WorldTwo extends AppCompatActivity {

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
    ImageButton egg13;
    ImageButton egg14;
    ImageButton egg15;
    ImageButton egg16;
    ImageButton egg17;
    ImageButton egg18;
    ImageButton egg19;
    ImageButton egg20;

    private int foundEggs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_world_two);


        //egg good
        egg1 = (ImageButton) findViewById(R.id.egg1);
        egg1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                foundEggs++;
                Bundle b = new Bundle();
                b.putInt("key", foundEggs);
                Intent intent = new Intent(getApplicationContext(), Two_GoodEgg.class);
                intent.putExtras(b);
                startActivity(intent);
                egg1.setVisibility(View.INVISIBLE);
                shouldFinish();
            }
        });

//        //egg good
//        egg2 = (ImageButton) findViewById(R.id.egg2);
//        egg2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                foundEggs++;
//                Bundle b = new Bundle();
//                b.putInt("key", foundEggs);
//                Intent intent = new Intent(getApplicationContext(), Two_GoodEgg.class);
//                intent.putExtras(b);
//                startActivity(intent);
//                egg2.setVisibility(View.INVISIBLE);
//                shouldFinish();
//            }
//        });

        //egg smashed
//        egg3 = (ImageButton) findViewById(R.id.egg3);
//        egg3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg3.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
        egg4 = (ImageButton) findViewById(R.id.egg4);
        egg4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg4.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg5 = (ImageButton) findViewById(R.id.egg5);
        egg5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg5.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
//        egg6 = (ImageButton) findViewById(R.id.egg6);
//        egg6.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg6.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
        egg7 = (ImageButton) findViewById(R.id.egg7);
        egg7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg7.setVisibility(View.INVISIBLE);
            }
        });

//        //egg smashed
//        egg8 = (ImageButton) findViewById(R.id.egg8);
//        egg8.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg8.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
        egg9 = (ImageButton) findViewById(R.id.egg9);
        egg9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg9.setVisibility(View.INVISIBLE);
            }
        });

//        //egg smashed
//        egg10 = (ImageButton) findViewById(R.id.egg10);
//        egg10.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg10.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
//        egg11 = (ImageButton) findViewById(R.id.egg11);
//        egg11.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg11.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
        egg12 = (ImageButton) findViewById(R.id.egg12);
        egg12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg12.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
//        egg13 = (ImageButton) findViewById(R.id.egg13);
//        egg13.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg13.setVisibility(View.INVISIBLE);
//            }
//        });

        //egg smashed
        egg14 = (ImageButton) findViewById(R.id.egg14);
        egg14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg14.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg15 = (ImageButton) findViewById(R.id.egg15);
        egg15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg15.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg16 = (ImageButton) findViewById(R.id.egg16);
        egg16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg16.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg17 = (ImageButton) findViewById(R.id.egg17);
        egg17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg17.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg18 = (ImageButton) findViewById(R.id.egg18);
        egg18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg18.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
        egg19 = (ImageButton) findViewById(R.id.egg19);
        egg19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg19.setVisibility(View.INVISIBLE);
            }
        });

        //egg smashed
//        egg20 = (ImageButton) findViewById(R.id.egg20);
//        egg20.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
//                startActivity(intent);
//                egg20.setVisibility(View.INVISIBLE);
//            }
//        });
    }

    public void shouldFinish() {
        if (foundEggs == 2) {
            this.finish();
        }
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

}
