package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Two_GiveEggToComputer extends AppCompatActivity {

    TextView text;

    ImageView eggPic;
    ImageView folderPic;
    Button returnToWorldSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__give_egg_to_computer);

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the computer the egg and your training data.");

        eggPic = (ImageView) findViewById(R.id.eggView);
        eggPic.setImageResource(R.drawable.egg);

        folderPic = (ImageView) findViewById(R.id.folderView);
        folderPic.setImageResource(R.drawable.folder);

        returnToWorldSelection = (Button) findViewById(R.id.returnToWorldTwoID);

    }

    public void returnToWorldTwo(View view){
        this.finish();
    }
}
