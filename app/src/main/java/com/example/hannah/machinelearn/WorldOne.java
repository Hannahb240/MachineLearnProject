package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class WorldOne extends AppCompatActivity {

    //Tree buttons
    ImageButton treeButton1;
    ImageButton treeButton2;
    ImageButton treeButton3;
    ImageButton treeButton4;
    ImageButton treeButton5;
    ImageButton treeButton6;
    ImageButton treeButton7;
    ImageButton treeButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_one);

        //Return button
        Button returnButton = (Button) findViewById(R.id.returnButton);

        //Tree  1
        treeButton1 = (ImageButton) findViewById(R.id.selectTree1);
        treeButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 2
        treeButton2 = (ImageButton) findViewById(R.id.selectTree2);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 3
        treeButton2 = (ImageButton) findViewById(R.id.selectTree3);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 4
        treeButton2 = (ImageButton) findViewById(R.id.selectTree4);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 5
        treeButton2 = (ImageButton) findViewById(R.id.selectTree5);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 6
        treeButton2 = (ImageButton) findViewById(R.id.selectTree6);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 7
        treeButton2 = (ImageButton) findViewById(R.id.selectTree7);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

        //Tree 7
        treeButton2 = (ImageButton) findViewById(R.id.selectTree8);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                startActivity(intent);
            }
        });

    }

    //Method to change activity on button click
    public void changeActivity(View view){
        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();

        if(buttonText.equals("return")){
            this.finish();
        }
    }

}
