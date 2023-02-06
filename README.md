## Installation

```bash
  maven { url 'https://jitpack.io' }
```

- Add this tag in manifest

```bash
   <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="${APP_ID}" />
  
```

```bash
 public class App extends MyApplication {
    public static final String PRODUCT_LIFETIME = "android.test.purchased";

    @Override
    protected void onApplicationCreate() {
      // Not show Ad Resume With MainActivity
      AppOpenManager.getInstance().disableAppResumeWithActivity(MainActivity.class);
    }

    //For Develop
    @Override
    protected boolean hasAds() {
        return true;
    }

    @Override
    protected boolean isShowDialogLoadingAd() {
        return true;
    }
    
    //Always show ad test when debuging
    @Override
    protected boolean isShowAdsTest() {
        return BuildConfig.DEBUG;
    }

    @Override
    public boolean enableAdsResume() {
        return true;
    }

    @Override
    public String getOpenAppAdId() {
        return "ca-app-pub-3940256099942544/3419835294";
    }


    @Override
    public boolean isInitBilling() {
        return false;
    }

    @Override
    public List<PurchaseModel> getPurchaseList() {
        return Collections.singletonList(new PurchaseModel(PRODUCT_LIFETIME, PurchaseModel.ProductType.INAPP));
    }

    @Override
    protected AppConfig getAppConfig() {
        return new AppConfig.AppConfigBuilder().setEmailSupport("email_support").setSubjectSupport("subject_sp").setPolicyUrl("policy_url")
                .setSubjectShare("subject_share").build();
    }
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
                    
                    @Override
                    public void onAdFailedToLoad(LoadAdError i) {
                    //TODO
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
                    @Override
                    public void onAdFailedToShowFullScreenContent(LoadAdError errAd) {
                        //TODO
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
    
 AdmobManager.getInstance().loadBanner(context, "native_id",
  place_holder,collapsibleType);

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





    





