package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LemonResult extends AppCompatActivity {

    TextView text;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lemon_result);

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the king your training data and the lemon.");

        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void selectNext(View view) {
        this.finish();
    }


}
