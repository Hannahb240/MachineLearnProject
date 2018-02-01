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

        //Tree 1
        treeButton1 = (ImageButton) findViewById(R.id.selectTree1);
        treeButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LemonTree.class);
                Bundle b = new Bundle();
                b.putInt("key", 1); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree1).setBackgroundResource(R.drawable.lemontree);
            }
        });

        //Tree 2
        treeButton2 = (ImageButton) findViewById(R.id.selectTree2);
        treeButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 2); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree2).setBackgroundResource(R.drawable.orangetree);
            }
        });

        //Tree 3
        treeButton3 = (ImageButton) findViewById(R.id.selectTree3);
        treeButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 3); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree3).setBackgroundResource(R.drawable.appletree);
            }
        });

        //Tree 4
        treeButton4 = (ImageButton) findViewById(R.id.selectTree4);
        treeButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 4); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree4).setBackgroundResource(R.drawable.peartree);
            }
        });

        //Tree 5
        treeButton5 = (ImageButton) findViewById(R.id.selectTree5);
        treeButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 2); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree5).setBackgroundResource(R.drawable.orangetree);
            }
        });

        //Tree 6
        treeButton6 = (ImageButton) findViewById(R.id.selectTree6);
        treeButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 3); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree6).setBackgroundResource(R.drawable.appletree);
            }
        });

        //Tree 7
        treeButton7 = (ImageButton) findViewById(R.id.selectTree7);
        treeButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 4); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree7).setBackgroundResource(R.drawable.peartree);
            }
        });

        //Tree 8
        treeButton8 = (ImageButton) findViewById(R.id.selectTree8);
        treeButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tree.class);
                Bundle b = new Bundle();
                b.putInt("key", 3); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                findViewById(R.id.selectTree8 ).setBackgroundResource(R.drawable.appletree);
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
