package com.common.control.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


public class LanguagePrefs {

    private static final String PREFS_NAME = "multi_language_active.pref";
    public static final String LANGUAGE = "laguage";

    private static LanguagePrefs mInstance;
    private final SharedPreferences mSharedPreferences;

    private LanguagePrefs(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static LanguagePrefs getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new LanguagePrefs(context);
        }
        return mInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass) {
        if (anonymousClass == String.class) {
            return (T) mSharedPreferences.getString(key, "");
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        } else {
            return (T) new Gson()
                    .fromJson(mSharedPreferences.getString(key, ""), anonymousClass);
        }
    }

    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else {
            editor.putString(key, new Gson().toJson(data));
        }
        editor.apply();
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }
}
