package com.masterlibs.commonlibs;

import com.common.control.MyApplication;

public class App extends MyApplication {

    @Override
    protected void onApplicationCreate() {

    }

    @Override
    protected boolean hasAds() {
        return true;
    }

    @Override
    protected boolean isShowDialogLoadingAd() {
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
}
