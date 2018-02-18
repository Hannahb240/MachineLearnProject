package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class One_PearTree extends AppCompatActivity {

    Button nextButton;
    TextView pearTreeInstructions;
    boolean clickedNextOnceAlreadyFlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_pear_tree);

        clickedNextOnceAlreadyFlag = false;

        //Instuctions
        pearTreeInstructions = (TextView) findViewById(R.id.pearInstructions);
        pearTreeInstructions.setText("Be creative and come up with your own action to get the fruit from the tree!");
        pearTreeInstructions.setTextColor(Color.parseColor("#000000"));

        //Next button
        nextButton = (Button) findViewById(R.id.nextButton);


    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if (!clickedNextOnceAlreadyFlag) {
                pearTreeInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            } else {
                Intent intent = new Intent(getApplicationContext(), One_TakePhoto.class);
                Bundle b = new Bundle();
                b.putInt("key", 4);
                intent.putExtras(b);
                startActivity(intent);
                this.finish();
            }

        }
    }
    public void backButton(View view){
        this.finish();
    }
}
