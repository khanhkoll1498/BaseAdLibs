
## Installation
```bash
  maven { url 'https://jitpack.io' }
```
```bash
  implementation 'com.github.MTGLibs:CommonLibs:1.2.5'
```

## Features

- Load ad
- Base structor
- Common Method


## Documentation

[Policy Admob](https://support.google.com/admob/answer/6128543?hl=en)

## Load a InterstialAd
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
 AdmobManager.getInstance().showInterstitial(context, "YOUR_INTERSTIAL", new AdCallback() {
                    @Override
                    public void onAdClosed() {
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





    





