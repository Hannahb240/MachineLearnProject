package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class One_LemonTree extends AppCompatActivity {

    Button nextButton;
    TextView lemonTreeInstructions;
    boolean clickedNextOnceAlreadyFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_tree);
        clickedNextOnceAlreadyFlag = false;

        //Instuctions
        lemonTreeInstructions = (TextView) findViewById(R.id.lemonInstructions);
        lemonTreeInstructions.setText("Looks like you'll need to reach up to get the fruit from the tree.");
        lemonTreeInstructions.setTextColor(Color.parseColor("#000000"));

        //Next button
        nextButton = (Button) findViewById(R.id.nextButton);

    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if(!clickedNextOnceAlreadyFlag) {
                lemonTreeInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            }
            else{
                Intent intent = new Intent(getApplicationContext(), One_TakePhoto.class);
                Bundle b = new Bundle();
                b.putInt("key", 1); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                this.finish();
            }

        }
    }

    public void backButton(View view){
        this.finish();
    }
}