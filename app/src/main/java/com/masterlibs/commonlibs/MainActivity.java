package com.masterlibs.commonlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("android_log", "onCreate: MainActivity");
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.bt_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondScreenActivity.start(MainActivity.this);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("android_log", "onRestart: MainActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("android_log", "onStart: MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("android_log", "onResume: MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("android_log", "onPause: MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("android_log", "onStop: MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("android_log", "onDestroy: MainActivity");
    }
}