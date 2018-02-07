package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_Lemon_GiveLemonToKing extends AppCompatActivity {

    TextView text;

    ImageView lemonPic;
    ImageView folderPic;
    Button returnToWorldSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_give_lemon_to_king);

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the king the lemon and your training data.");

        lemonPic = (ImageView) findViewById(R.id.lemon);
        lemonPic.setImageResource(R.drawable.lemon);

        folderPic = (ImageView) findViewById(R.id.folder);
        folderPic.setImageResource(R.drawable.folder);

        returnToWorldSelection = (Button) findViewById(R.id.returnToWorldOneID);


    }

    public void returnToWorldOne(View view){
        this.finish();
    }
}
