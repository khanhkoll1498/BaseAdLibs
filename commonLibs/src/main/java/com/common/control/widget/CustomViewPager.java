package com.common.control.widget;

import android.content.Context;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    public CustomViewPager(@NonNull Context context) {
        super(context);
    }
    private boolean isPagingEnabled;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isPagingEnabled && super.onInterceptTouchEvent(ev);
    }

    public void setPagingEnabled(boolean pagingEnabled) {
        isPagingEnabled = pagingEnabled;
    }
}
