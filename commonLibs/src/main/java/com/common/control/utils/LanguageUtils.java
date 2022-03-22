package com.common.control.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.common.control.model.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LanguageUtils {

    private static Language sCurrentLanguage = null;

    public static Language getCurrentLanguage(Context context) {
        if (sCurrentLanguage == null) {
            sCurrentLanguage = initCurrentLanguage(context);
        }
        return sCurrentLanguage;
    }


    private static Language initCurrentLanguage(Context context) {
        Language currentLanguage =
                LanguagePrefs.getInstance(context).get(LanguagePrefs.LANGUAGE, Language.class);
        if (currentLanguage != null) {
            return currentLanguage;
        }
        currentLanguage = new Language(0,
                "English",
                "en");
        LanguagePrefs.getInstance(context).put(LanguagePrefs.LANGUAGE, currentLanguage);
        return currentLanguage;
    }

    /**
     * return language list from string.xml
     */
    public static List<Language> getLanguageData(Context context, int arrayLanguageResource) {
        List<Language> languageList = new ArrayList<>();
        List<String> languages =
                Arrays.asList(context.getResources().getStringArray(arrayLanguageResource));
        for (int i = 0; i < languages.size(); i++) {
            String[] str = languages.get(i).split(",");
            languageList.add(new Language(i, str[1], str[0]));

        }
        return languageList;
    }


    public static void loadLocale(Context context) {
        changeLanguage(context, initCurrentLanguage(context));
    }


    public static void changeLanguage(Context context, Language language) {
        if (language == null) {
            return;
        }
        try {
            LanguagePrefs.getInstance(context).put(LanguagePrefs.LANGUAGE, language);
            sCurrentLanguage = language;

            Locale locale = new Locale(language.getCode());
            Locale.setDefault(locale);

            Resources resources = context.getResources();

            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;

            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
