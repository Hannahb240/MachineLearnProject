package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Two_GoodEgg extends AppCompatActivity {

    TextView eggInstructions;
    Button nextButton;
    boolean clickedNextOnceAlreadyFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__good_egg);

        clickedNextOnceAlreadyFlag = false;

        //Instuctions
        eggInstructions = (TextView) findViewById(R.id.eggInstructions);
        eggInstructions.setText("Looks like you'll need crouch to pick up the egg");
        eggInstructions.setTextSize(30);

        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if(!clickedNextOnceAlreadyFlag) {
                eggInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            }
            else{
                Intent intent = new Intent(getApplicationContext(), Two_TakePhoto.class);
                startActivity(intent);
                this.finish();
            }

        }
    }

    public void goBack(View view){
        this.finish();
    }
}
