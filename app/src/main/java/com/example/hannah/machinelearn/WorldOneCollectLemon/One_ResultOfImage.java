package com.example.hannah.machinelearn.WorldOneCollectLemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class One_ResultOfImage extends AppCompatActivity {

    int typeOfTree;
    TextView resultOfPhotoText;
    ImageView treeTypeImageView;

    Button nextButton;
    Button returnToWorldOne;

    int flagForNextSelectedOnTypeLemon;

    RelativeLayout layout;

    String orangeText;
    String lemonText;
    String appleText;
    String pearText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_result_of_image);

        treeTypeImageView= (ImageView) findViewById(R.id.treeType);
        resultOfPhotoText = (TextView) findViewById(R.id.result);

        nextButton = (Button) findViewById(R.id.nextButton);
        returnToWorldOne = (Button) findViewById(R.id.returnButton);

        layout = new RelativeLayout(this);
        flagForNextSelectedOnTypeLemon = 0;

        setTreeText();

        //Get the parameter set by the previous activity. Used to set the tree image in the result class.
        Bundle b = getIntent().getExtras();
        typeOfTree = b.getInt("key");

        displayNextStepsBasedOnTreeType(typeOfTree);
    }


    public void selectNext(View view) {

        if(typeOfTree == 1){
            if(flagForNextSelectedOnTypeLemon ==0) {

                Utils.setInstructions(resultOfPhotoText, "How are you going to collect a lemon from the lemon tree?");
                flagForNextSelectedOnTypeLemon +=1;
            }
            else if(flagForNextSelectedOnTypeLemon == 1){
                Intent intent = new Intent(getApplicationContext(), One_TakePhoto.class);
                startActivity(intent);
                this.finish();
            }
        }
    }

    public void returnToWorldOne(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Back")) {
            this.finish();
        }
    }

    public void setTreeText() {

        orangeText = "This is an orange tree! Tap the back button below to keep searching for the lemon tree.";
        lemonText = "Hooray, you found the lemon tree! Tap the next button.";
        appleText = "This is an apple tree! Tap the back button below to keep searching for the lemon tree.";
        pearText = "This is a pear tree! Tap the back button below to keep searching for the lemon tree.";
    }

    public void displayNextStepsBasedOnTreeType(int typeOfTree) {

        switch(typeOfTree) {
            case 1:
                layout.setBackgroundResource(R.drawable.lemonbackground);
                returnToWorldOne.setVisibility(View.INVISIBLE);
                treeTypeImageView.setImageResource(R.drawable.lemontree);
                Utils.setInstructions(resultOfPhotoText, lemonText);
                break;
            case 2:
                nextButton.setVisibility(View.INVISIBLE);
                treeTypeImageView.setImageResource(R.drawable.orangetree);
                Utils.setInstructions(resultOfPhotoText, orangeText);
                break;
            case 3:
                nextButton.setVisibility(View.INVISIBLE);
                treeTypeImageView.setImageResource(R.drawable.appletree);
                Utils.setInstructions(resultOfPhotoText, appleText);
                break;
            case 4:
                nextButton.setVisibility(View.INVISIBLE);
                treeTypeImageView.setImageResource(R.drawable.peartree);
                Utils.setInstructions(resultOfPhotoText, pearText);
                break;
        }

    }



}
