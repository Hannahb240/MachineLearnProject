package com.example.hannah.machinelearn.WorldOneCollectLemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Tree;

public class One_LemonTree extends AppCompatActivity implements Tree {

    Button nextButton;
    boolean clickedNextOnceAlreadyFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_tree);

        clickedNextOnceAlreadyFlag = false;
        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void goToNextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();

        if (buttonText.equals("Next")) {
            onNext();
        }
    }

    public void onNext() {

        if(!clickedNextOnceAlreadyFlag) {
            clickedNextOnceAlreadyFlag = true;
        }
        else{
            Intent intent = new Intent(getApplicationContext(), One_TakePhoto.class);
            Bundle b = new Bundle();
            b.putInt("key", 1); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);
            this.finish();
        }
    }

    public void backButton(View view)
    {
        this.finish();
    }
}