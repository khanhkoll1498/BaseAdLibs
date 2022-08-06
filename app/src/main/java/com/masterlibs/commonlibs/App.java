package com.masterlibs.commonlibs;

import com.common.control.MyApplication;
import com.common.control.manager.PurchaseManager;
import com.common.control.model.PurchaseModel;

import java.util.Collections;
import java.util.List;

public class App extends MyApplication {
    public static final String PRODUCT_LIFETIME = "android.test.purchased";

    @Override
    protected void onApplicationCreate() {
        PurchaseManager.getInstance().init(this, Collections.singletonList(new PurchaseModel(PRODUCT_LIFETIME, PurchaseModel.ProductType.INAPP)));
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

    @Override
    public String getPolicyUrl() {
        return null;
    }

    @Override
    public boolean isInitBilling() {
        return false;
    }

    @Override
    public List<PurchaseModel> getPurchaseList() {
        return null;
    }
}
