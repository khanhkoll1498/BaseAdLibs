package com.masterlibs.commonlibs;

import androidx.viewbinding.BuildConfig;

import com.master.prolibs.AppConfig;
import com.master.prolibs.MyApplication;
import com.master.prolibs.manager.AppOpenManager;
import com.master.prolibs.model.PurchaseModel;

import java.util.Collections;
import java.util.List;

public class App extends MyApplication {
    public static final String PRODUCT_LIFETIME = "android.test.purchased";

    @Override
    protected void onApplicationCreate() {
        AppOpenManager.getInstance().disableAppResumeWithActivity(MainActivity.class);
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
    public boolean hasPurchase() {
        return false;
    }

    @Override
    public List<PurchaseModel> getPurchaseList() {
        return Collections.singletonList(new PurchaseModel(PRODUCT_LIFETIME, PurchaseModel.ProductType.INAPP));
    }

    @Override
    protected AppConfig getAppConfig() {
        return new AppConfig.AppConfigBuilder().setEmailSupport("email_support").setSubjectSupport("subject_sp").setPolicyUrl("policy_url").setSubjectShare("subject_share").build();
    }
}
