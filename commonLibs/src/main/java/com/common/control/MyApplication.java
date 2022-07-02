package com.common.control;

import android.app.Application;

import com.common.control.manager.AdmobManager;
import com.common.control.manager.AppOpenManager;


public abstract class MyApplication extends Application {

    @Override
    public final void onCreate() {
        super.onCreate();

        AdmobManager.getInstance().init(this, isShowAdsTest() ? AdmobManager.getInstance().getDeviceId(this) : "");
        AdmobManager.getInstance().hasAds(hasAds());
        if (enableAdsResume()) {
            AppOpenManager.getInstance().init(this, getOpenAppAdId());
        }
        AdmobManager.getInstance().setShowLoadingDialog(isShowDialogLoadingAd());
        onApplicationCreate();
//        PurchaseManager.getInstance().initBilling(this);
    }


    protected abstract void onApplicationCreate();

    protected abstract boolean hasAds();

    protected abstract boolean isShowDialogLoadingAd();

    protected abstract boolean isShowAdsTest();

    public abstract boolean enableAdsResume();

    public abstract String getOpenAppAdId();
}
