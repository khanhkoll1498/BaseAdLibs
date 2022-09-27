
## Init
 **Step 1: ** public class App extends MyApplication
 **Step 2: ** Add App class to Manifest
---

## Load a Interstial Ad
 **Step 1: ** Request interstial by method:
  AdmobManager.getInstance()
                .loadInterAds(SplashActivity.this, BuildConfig.inter_splash, new AdCallback() {
                    @Override
                    public void onResultInterstitialAd(InterstitialAd interstitialAd) {
                        super.onResultInterstitialAd(interstitialAd);
                 
                    }
                });
 
 **Step 2: ** Add App class to Manifest

---

## Load a banner

---

## Load a Native


---
