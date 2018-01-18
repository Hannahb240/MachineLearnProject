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
    ImageButton treeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_one);

        //Return button
        Button returnButton = (Button) findViewById(R.id.returnButton);

        //Tree number 1
        treeButton = (ImageButton) findViewById(R.id.selectTree);
        treeButton.setOnClickListener(new View.OnClickListener() {
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
