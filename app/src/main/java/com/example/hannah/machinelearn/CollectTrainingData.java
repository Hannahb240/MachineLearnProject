package com.example.hannah.machinelearn;

import android.content.Intent;
import android.view.View;

public interface CollectTrainingData {

    void takePhotograph(View view);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void changeActivity(View view);

    void setInitialImageViews();

}
