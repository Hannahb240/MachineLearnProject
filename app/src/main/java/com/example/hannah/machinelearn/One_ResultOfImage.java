package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_ResultOfImage extends AppCompatActivity {

    int typeOfTree;
    TextView resultOfPhoto;

    Button nextButton;
    Button returnToWorldOne;

    int flagForNextSelectedOnTypeLemon;


    String orangeText = "You picked an orange! This must be an orange tree.";
    String lemonText = "Hooray you found the lemon!";
    String appleText = "You picked an apple! This must be an apple tree.";
    String pearText = "You picked a pear! This must be a pear tree.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_result_of_image);
        ImageView img= (ImageView) findViewById(R.id.fruitType);
        flagForNextSelectedOnTypeLemon = 0;

        resultOfPhoto = (TextView) findViewById(R.id.result);

        nextButton = (Button) findViewById(R.id.nextButton);
        returnToWorldOne = (Button) findViewById(R.id.returnButton);
        returnToWorldOne.setVisibility(View.INVISIBLE);


        //Get the parameter set by the previous activity.
        //This parameter is used to set the image in the result class.
        Bundle b = getIntent().getExtras();
        typeOfTree = b.getInt("key");

        switch(typeOfTree) {
            case 1:
                img.setImageResource(R.drawable.lemon);
                resultOfPhoto.setText(lemonText);
                setText(lemonText);
                break;
            case 2:
                img.setImageResource(R.drawable.orange);
                setText(orangeText);
                break;
            case 3:
                img.setImageResource(R.drawable.apple);
                setText(appleText);
                break;
            case 4:
                img.setImageResource(R.drawable.pear);
                setText(pearText);
                break;
        }
    }

    public void setText(String textToSet){
        resultOfPhoto.setText(textToSet);
        resultOfPhoto.setTextColor(Color.parseColor("#000000"));
    }

    public void selectNext(View view) {

        if(typeOfTree == 1){
            if(flagForNextSelectedOnTypeLemon ==0) {
                resultOfPhoto.setText("The computer wants you to teach it how you collected this.");
                flagForNextSelectedOnTypeLemon +=1;
            }
            else if(flagForNextSelectedOnTypeLemon == 1){
                Intent intent = new Intent(getApplicationContext(), One_Lemon_LemonResult.class);
                startActivity(intent);
                this.finish();
            }
        }

        else {
            resultOfPhoto.setText("Keep seatching until you find the lemon");
            returnToWorldOne.setVisibility(View.VISIBLE);
        }
    }

    public void returnToWorldOne(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Return")) {
            this.finish();
        }
    }

}
