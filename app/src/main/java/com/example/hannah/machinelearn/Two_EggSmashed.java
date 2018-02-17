package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Two_EggSmashed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__egg_smashed);
    }

    public void returnToWorldTwo(View view) {
        this.finish();
    }
}
