package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultOfImage extends AppCompatActivity {

    Button returnToWorldOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_image);


        returnToWorldOne = (Button) findViewById(R.id.returnButton);
    }

    //add a return button
    public void changeActivity(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("return")) {
            this.finish();
        }
    }

    //when clicked, you return to worldone. close 2 activities


}
