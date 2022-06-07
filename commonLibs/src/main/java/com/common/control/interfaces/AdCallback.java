package com.common.control.interfaces;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;

abstract public class AdCallback {
    public AdCallback() {
    }

    public void onAdClosed() {
    }

    public void onAdShowed() {
    }


    public void onAdFailedToLoad(@NonNull LoadAdError i) {
    }

    public void onAdLoaded() {
    }

    @Deprecated
    public void interCallback(InterstitialAd interstitialAd) {
    }

    public void onResultInterstitialAd(InterstitialAd interstitialAd) {
    }

    public void onNativeAds(NativeAd nativeAd) {

    }
}
