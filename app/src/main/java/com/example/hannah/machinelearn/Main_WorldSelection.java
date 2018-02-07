package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_WorldSelection extends AppCompatActivity {


    Button worldOneButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        worldOneButton = (Button) findViewById(R.id.goToWorld);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_world_selection);
    }


    public void changeToWorld(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("World one")) {
            Intent intent = new Intent(getApplicationContext(), One_WorldOne.class);
            startActivity(intent);
        }
    }
}
