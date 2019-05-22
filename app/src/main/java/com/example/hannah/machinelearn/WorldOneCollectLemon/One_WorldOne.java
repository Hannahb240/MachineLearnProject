package com.example.hannah.machinelearn.WorldOneCollectLemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hannah.machinelearn.R;

public class One_WorldOne extends AppCompatActivity {

    //Tree buttons
    ImageButton treeButton1;
    ImageButton treeButton2;
    ImageButton treeButton3;
    ImageButton treeButton4;
    ImageButton treeButton5;
    ImageButton treeButton6;
    ImageButton treeButton7;
    ImageButton treeButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_world_one);

        setOnClickListeners();
    }

    public void setOnClickListeners(){

        treeButton1 = (ImageButton) findViewById(R.id.selectTree1);
        treeButton1.setOnClickListener(new TreeListener(1, 1));

        treeButton2 = (ImageButton) findViewById(R.id.selectTree2);
        treeButton2.setOnClickListener(new TreeListener(2, 2));

        treeButton3 = (ImageButton) findViewById(R.id.selectTree3);
        treeButton3.setOnClickListener(new TreeListener(3, 3));

        treeButton4 = (ImageButton) findViewById(R.id.selectTree4);
        treeButton4.setOnClickListener(new TreeListener(4, 4));

        treeButton5 = (ImageButton) findViewById(R.id.selectTree5);
        treeButton5.setOnClickListener(new TreeListener(2, 5));

        treeButton6 = (ImageButton) findViewById(R.id.selectTree6);
        treeButton6.setOnClickListener(new TreeListener(3, 6));

        treeButton7 = (ImageButton) findViewById(R.id.selectTree7);
        treeButton7.setOnClickListener(new TreeListener(4, 7));

        treeButton8 = (ImageButton) findViewById(R.id.selectTree8);
        treeButton8.setOnClickListener(new TreeListener(3, 8));

    }

    public void changeActivity(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Back")) {
            this.finish();
        }
        if (buttonText.equals("Rules")) {
            Intent intent = new Intent(getApplicationContext(), One_Rules.class);
            startActivity(intent);
        }
    }

    public int findTreeResId(int id) {

        if(id == 1){
            return getResources().getIdentifier("lemontree", "drawable", getPackageName());
        }
        if(id == 2){
            return getResources().getIdentifier("orangetree", "drawable", getPackageName());
        }
        else if(id == 3){
            return getResources().getIdentifier("appletree", "drawable", getPackageName());
        }
        else if(id == 4){
            return getResources().getIdentifier("peartree", "drawable", getPackageName());
        }
        return 0;
    }

    public int getTreeImageView(int imageViewNumber){

        return getResources().getIdentifier("selectTree" + imageViewNumber, "id", getPackageName());
    }

    class TreeListener implements View.OnClickListener {

        int valueOfKey;
        int idOfTreeImageView;
        int idOfTreeBackgroundRes;

        public TreeListener(int treeType, int treeImageViewNumber){

            this.valueOfKey = treeType;
            this.idOfTreeImageView = getTreeImageView(treeImageViewNumber);
            this.idOfTreeBackgroundRes = findTreeResId(treeType);
        }

        @Override
        public void onClick(View v) {
            treeClicked(valueOfKey, idOfTreeImageView, idOfTreeBackgroundRes);
        }
    }

    private void treeClicked(int valueOfKey, int idOfTreeImageView, int idOfTreeBackgroundRes) {
        Intent intent = new Intent(getApplicationContext(), One_ResultOfImage.class);
        Bundle b = new Bundle();
        b.putInt("key", valueOfKey);
        intent.putExtras(b);
        startActivity(intent);
        findViewById(idOfTreeImageView).setBackgroundResource(idOfTreeBackgroundRes);
        if(valueOfKey == 1){
            finish();
        }
    }
}
