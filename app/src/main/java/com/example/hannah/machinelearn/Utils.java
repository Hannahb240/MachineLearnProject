package com.example.hannah.machinelearn;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by Hannah on 21/05/2019.
 */

public class Utils {

    public static void setInstructions(TextView instructionsTextView, String textToSet) {

        instructionsTextView.setTextColor(Color.parseColor("#000000"));
        instructionsTextView.setTextSize(20);
        instructionsTextView.setText(textToSet);
    }

}
