package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultOfImage extends AppCompatActivity {


    Button returnToWorldOne;
    int typeOfTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_image);
        ImageView img= (ImageView) findViewById(R.id.fruitType);


        //Get the parameter set by the previous activity.
        //This parameter is used to set the image in the result class.
        Bundle b = getIntent().getExtras();
        typeOfTree = b.getInt("key");

        switch(typeOfTree){
            case 1:img.setImageResource(R.drawable.lemon);
                break;
            case 2:img.setImageResource(R.drawable.orange);
                break;
            case 3: img.setImageResource(R.drawable.apple);
                break;
            case 4: img.setImageResource(R.drawable.pear);
                break;
        }
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
