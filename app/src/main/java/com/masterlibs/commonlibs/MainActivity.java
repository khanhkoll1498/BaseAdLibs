package com.masterlibs.commonlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.common.control.dialog.PermissionStorageDialog;
import com.common.control.interfaces.AdCallback;
import com.common.control.interfaces.PermissionCallback;
import com.common.control.manager.AdmobManager;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("android_log", "onCreate: MainActivity");
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionStorageDialog.start(MainActivity.this, new PermissionCallback() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(MainActivity.this, "onPermissionGranted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied() {
                        Toast.makeText(MainActivity.this, "onPermissionDenied", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        AdmobManager.getInstance().loadInterAds(this, "ca-app-pub-3940256099942544/8691691433", new AdCallback() {
            @Override
            public void interCallback(InterstitialAd interstitialAd) {
                super.interCallback(interstitialAd);
                AdmobManager.getInstance().showInterstitial(MainActivity.this, interstitialAd, this);
            }

            @Override
            public void onAdFailedToLoad(LoadAdError i) {
                super.onAdFailedToLoad(i);
                startActivity(new Intent(MainActivity.this, SecondScreenActivity.class));
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this, SecondScreenActivity.class));
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