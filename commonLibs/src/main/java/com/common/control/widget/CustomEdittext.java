package com.common.control.widget;

import android.content.Context;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomEdittext extends AppCompatEditText {
    public CustomEdittext(@NonNull Context context) {
        super(context);
    }

    private OnHideKeyboardListener mOnHideKeyboardListener;

    public void setmOnHideKeyboardListener(OnHideKeyboardListener mOnHideKeyboardListener) {
        this.mOnHideKeyboardListener = mOnHideKeyboardListener;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (mOnHideKeyboardListener != null) {
                mOnHideKeyboardListener.onHideKeyboard();
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    private interface OnHideKeyboardListener {
        void onHideKeyboard();
    }
}
