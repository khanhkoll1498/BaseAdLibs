package com.common.control;

import android.app.Application;

import com.common.control.manager.AdmobManager;
import com.common.control.manager.AppOpenManager;
import com.common.control.manager.PurchaseManager;
import com.common.control.model.PurchaseModel;
import com.common.control.utils.AppUtils;
import com.common.control.utils.SharePrefUtils;

import java.util.List;


public abstract class MyApplication extends Application {

    @Override
    public final void onCreate() {
        super.onCreate();

        SharePrefUtils.getInstance().init(this);
        AdmobManager.getInstance().init(this, isShowAdsTest() ? AdmobManager.getInstance().getDeviceId(this) : "");
        AdmobManager.getInstance().hasAds(hasAds());
        if (enableAdsResume()) {
            AppOpenManager.getInstance().init(this, getOpenAppAdId());
        }
        AdmobManager.getInstance().setShowLoadingDialog(isShowDialogLoadingAd());
        onApplicationCreate();

        AppUtils.getInstance().setPolicyUrl(getPolicyUrl());
        AppUtils.getInstance().setEmail(getEmailSupport());
        AppUtils.getInstance().setSubject(getSubjectSupport());

        if (isInitBilling()) {
            PurchaseManager.getInstance().init(this, getPurchaseList());
        }
    }


    protected abstract void onApplicationCreate();

    protected abstract boolean hasAds();

    protected abstract boolean isShowDialogLoadingAd();

    protected abstract boolean isShowAdsTest();

    protected abstract boolean enableAdsResume();

    protected abstract String getOpenAppAdId();

    protected abstract String getPolicyUrl();

    protected abstract String getSubjectSupport();

    protected abstract String getEmailSupport();

    protected abstract boolean isInitBilling();

    protected abstract List<PurchaseModel> getPurchaseList();

}
