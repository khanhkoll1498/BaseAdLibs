package com.common.control;

import android.app.Application;

import com.common.control.manager.AdmobManager;
import com.common.control.manager.AppOpenManager;
import com.common.control.manager.PurchaseManager;


public abstract class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdmobManager.getInstance().init(this, isShowAdsTest() ? AdmobManager.getInstance().getDeviceId(this) : "");
        AdmobManager.getInstance().isPurchased(isPurchased());
        if (enableAdsResume()) {
            AppOpenManager.getInstance().init(this, getOpenAppAdId());
        }
        PurchaseManager.getInstance().initBilling(this);
    }

    protected abstract boolean isPurchased();

    protected abstract boolean isShowAdsTest();

    public abstract boolean enableAdsResume();

    public abstract String getOpenAppAdId();
}
