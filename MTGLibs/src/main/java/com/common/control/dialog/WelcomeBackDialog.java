package com.common.control.dialog;

import android.os.Bundle;
import android.view.ViewGroup;

import com.common.control.R;
import com.common.control.base.BaseDialog;
import com.common.control.databinding.DialogWelcomeBackBinding;

public class WelcomeBackDialog extends BaseDialog<DialogWelcomeBackBinding> {
    public static WelcomeBackDialog newInstance() {
        Bundle args = new Bundle();
        WelcomeBackDialog fragment = new WelcomeBackDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setLayout(width, height);
    }

    @Override
    protected void prepareDialog() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_welcome_back;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void addEvent() {

    }
}
