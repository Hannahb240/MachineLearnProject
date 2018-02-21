package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Five_GuessPoseButtons extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_pose_buttons);
    }

    public void goToGuessPose(View view){
        Bundle b = new Bundle();

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Reaching to get a lemon from the tree")) {
            b.putInt("key", 1);
        }
        else if(buttonText.equals("Picking up an egg from the ground")){
            b.putInt("key", 2);
        }
        else if(buttonText.equals("Pulling a turnip out of the ground")){
            b.putInt("key", 3);
        }
        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        intent.putExtras(b);
        startActivity(intent);
        this.finish();
    }
}

