## Installation

```bash
  maven { url 'https://jitpack.io' }
```

```bash
  implementation 'com.github.MTGLibs:CommonLibs:1.2.5'
  
```
- Add this tag in manifest
```bash
   <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="${APP_ID}" />
  
```

```bash
  public class App extends MyApplication

  @Override
    protected boolean hasAds() {
        return true;
    }
  

  @Override
    protected boolean isShowAdsTest() {
        return false;
    }
  

  @Override
    public boolean enableAdsResume() {
        return false;
    }
 
  @Override
    public String getOpenAppAdId() {
        return null;
    }
 
  @Override
    protected boolean isShowDialogLoadingAd() {
        return true;
    }

```

## Features

- Load ad
- Base struct
- Common Method

## Documentation

[Policy Admob](https://support.google.com/admob/answer/6128543?hl=en)

## Load a Interstitial

**Request a Inter**

```bash
  AdmobManager.getInstance()
                .loadInterAds(context, "inter_splash", new AdCallback() {
                    @Override
                    public void onResultInterstitialAd(InterstitialAd interstitialAd) {
                        super.onResultInterstitialAd(interstitialAd);
                        // Admod result a InterstialAd. Save it to your cache to use.
                    }
                });
```

**Show a Inter**

```bash
 AdmobManager.getInstance().showInterstitial(context, "your_Interstitial", new AdCallback() {
                    @Override
                    public void onNextScreen() {
                        super.onAdClosed();
                        SecondScreenActivity.start(context);
                    }
                });
```

## Load Native Ad

**Step 1:** Create a place holder where contain native ad.

**Step 2:** Use this method to show native.

```bash
 AdmobManager.getInstance().loadNative(context, "native_id",
  place_holder, <Option> custom_native_layout);

```

## Load Banner Ad

**Step 1:** Create a place holder where contain banner ad.

**Step 2:** Use this method to show native.

```bash
 AdmobManager.getInstance().loadBanner(context, "native_id",
  place_holder);

```

## Admob id test

**APP_ID:**
```bash
ca-app-pub-3940256099942544~3347511713
```
**Banner:**
```bash
ca-app-pub-3940256099942544/6300978111
```
**Interstitial:**
```bash
ca-app-pub-3940256099942544/1033173712
```
**Native:**
```bash
ca-app-pub-3940256099942544/2247696110
```
**Open App:**
```bash
ca-app-pub-3940256099942544/3419835294
```


## Note

- Request 1 is shown 1. is not requested continuously. For example, the request cannot be
  re-requested when the request has failed before

- Do not click on ads

- Ads don't overlap the view





    





