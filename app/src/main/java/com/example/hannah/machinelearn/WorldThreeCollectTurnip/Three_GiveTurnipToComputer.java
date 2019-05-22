package com.example.hannah.machinelearn.WorldThreeCollectTurnip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;

public class Three_GiveTurnipToComputer extends AppCompatActivity {


    TextView text;

    ImageView turnipPic;
    ImageView folderPic;
    Button returnToWorldSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__give_turnip_to_computer);

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the computer the turnip and your training data.");

        turnipPic = (ImageView) findViewById(R.id.turnipView);
        turnipPic.setImageResource(R.drawable.turnip);

        folderPic = (ImageView) findViewById(R.id.folderView);
        folderPic.setImageResource(R.drawable.folder);

        returnToWorldSelection = (Button) findViewById(R.id.returnToWorldThreeID);

    }

    public void returnToWorldThree(View view){
        this.finish();
    }
}
