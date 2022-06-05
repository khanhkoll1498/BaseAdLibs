package com.masterlibs.commonlibs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondScreenActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, SecondScreenActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("android_log", "onCreate: SecondScreenActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("android_log", "onRestart: SecondScreenActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("android_log", "onStart: SecondScreenActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("android_log", "onResume: SecondScreenActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("android_log", "onPause: SecondScreenActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("android_log", "onStop: SecondScreenActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("android_log", "onDestroy: SecondScreenActivity");
    }
}
