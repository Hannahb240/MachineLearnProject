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


    String orangeText = "This is an orange tree! Tap the back button below to keep searching for the lemon tree.";
    String lemonText = "Hooray you found the lemon!";
    String appleText = "This is an apple tree! Tap the back button below to keep searching for the lemon tree.";
    String pearText = "This is a pear tree! Tap the back button below to keep searching for the lemon tree.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_result_of_image);
        ImageView img= (ImageView) findViewById(R.id.treeType);
        flagForNextSelectedOnTypeLemon = 0;

        resultOfPhoto = (TextView) findViewById(R.id.result);

        nextButton = (Button) findViewById(R.id.nextButton);
        returnToWorldOne = (Button) findViewById(R.id.returnButton);

        //Get the parameter set by the previous activity.
        //This parameter is used to set the image in the result class.
        Bundle b = getIntent().getExtras();
        typeOfTree = b.getInt("key");

        switch(typeOfTree) {
            case 1:
                img.setImageResource(R.drawable.lemontree);
                resultOfPhoto.setText(lemonText);
                setText(lemonText);
                break;
            case 2:
                img.setImageResource(R.drawable.orangetree);
                setText(orangeText);
                break;
            case 3:
                img.setImageResource(R.drawable.appletree);
                setText(appleText);
                break;
            case 4:
                img.setImageResource(R.drawable.peartree);
                setText(pearText);
                break;
        }
    }

    public void setText(String textToSet){
        resultOfPhoto.setText(textToSet);
        resultOfPhoto.setTextSize(20);
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
            //returnToWorldOne.setVisibility(View.VISIBLE);
        }
    }

    public void returnToWorldOne(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Back")) {
            this.finish();
        }
    }

}
