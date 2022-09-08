package com.masterlibs.commonlibs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.common.control.interfaces.AdCallback;
import com.common.control.interfaces.PurchaseCallback;
import com.common.control.manager.AdmobManager;
import com.common.control.manager.PurchaseManager;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static InterstitialAd inter;
    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("android_log", "onCreate: MainActivity");
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.bt_start);
        Button btBuy = findViewById(R.id.bt_buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                PermissionStorageDialog.start(MainActivity.this, new PermissionCallback() {
//                    @Override
//                    public void onPermissionGranted() {
//                        Toast.makeText(MainActivity.this, "onPermissionGranted", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onPermissionDenied() {
//                        Toast.makeText(MainActivity.this, "onPermissionDenied", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                SecondScreenActivity.start(MainActivity.this);
//                AdmobManager.getInstance().showInterstitial(MainActivity.this, inter, null);

                AdmobManager.getInstance().showRewardAd(MainActivity.this, rewardedAd, new AdCallback() {
                    @Override
                    public void onAdFailedToShowFullScreenContent(LoadAdError errAd) {
                        super.onAdFailedToShowFullScreenContent(errAd);
                    }

                    @Override
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        super.onUserEarnedReward(rewardItem);
                        rewardedAd = null;
                    }
                });
            }
        });
        PurchaseManager.getInstance().setCallback(new PurchaseCallback() {
            @Override
            public void purchaseSuccess() {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void purchaseFail() {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
        btBuy.setOnClickListener(v -> {
            if (PurchaseManager.getInstance().isPurchased()) {
                Toast.makeText(this, "Purchased", Toast.LENGTH_SHORT).show();
                return;
            }
            PurchaseManager.getInstance().launchPurchase(this, App.PRODUCT_LIFETIME);
        });
        findViewById(R.id.bt_consume).setOnClickListener(v -> {
            PurchaseManager.getInstance().consume(App.PRODUCT_LIFETIME);
        });


        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                AdvertisingIdClient.Info idInfo = null;
                try {
                    idInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String advertId = null;
                try{
                    advertId = idInfo.getId();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

                return advertId;
            }

            @Override
            protected void onPostExecute(String advertId) {
                Log.d("android_log", "onPostExecute: "+advertId);
                Toast.makeText(getApplicationContext(), advertId, Toast.LENGTH_SHORT).show();
            }

        };
        task.execute();

    }

    public int getResourceId(String pVariableName, String pResourcename, String pPackageName) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void loadInter() {
        AdmobManager.getInstance().loadInterAds(this, "ca-app-pub-3940256099942544/8691691433", new AdCallback() {
            @Override
            public void onResultInterstitialAd(InterstitialAd interstitialAd) {
                super.onResultInterstitialAd(interstitialAd);
                MainActivity.inter = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
        });

        AdmobManager.getInstance().loadRewardAd(this, "ca-app-pub-3940256099942544/5224354917", new RewardedAdLoadCallback() {

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                super.onAdLoaded(rewardedAd);
                MainActivity.this.rewardedAd = rewardedAd;
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
        loadInter();
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