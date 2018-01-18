 package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

 public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }

     Button goToWorldButton;
     ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        if(!OpenCVLoader.initDebug()) {
            tv.setText(tv.getText() + "\n OpenCVLoader.initDebug(), not working");
        }
        else {
            tv.setText(tv.getText() + "\n OpenCVLoader.initDebug(), working");
        }

        tv.setText(tv.getText() + "\n" + validate(0L, 0L));

        goToWorldButton = (Button) findViewById(R.id.goToWorldSelection);

    }

     public void changeActivity(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
         String buttonText = buttonPressed.getText().toString();
         if(buttonText.equals("Go to world selection")) {
             Intent intent = new Intent(getApplicationContext(), WorldSelection.class);
             startActivity(intent);
         }
     }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String validate(long matAddrGr, long matAddrRgba);
}
