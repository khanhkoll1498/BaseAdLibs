package com.common.control.utils;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtils {
    private static CommonUtils instance;
    private static final String TAG = CommonUtils.class.getName();

    public static boolean isShowNewInter = false;

    private CommonUtils() {
    }


    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }


    public void shareApp(Context context,String subject) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody =
                "https://play.google.com/store/apps/details?id=" + context.getPackageName();
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, "Share to"));
    }

    public void support(Context context,String subject,String email) {
        Intent mailIntent = new Intent(Intent.ACTION_VIEW);
        Uri data =
                Uri.parse("mailto:?SUBJECT=" + subject + "&body=" + "" + "&to=" + email);
        mailIntent.setData(data);
        context.startActivity(Intent.createChooser(mailIntent, "Send mail..."));
    }

    public void rateApp(Context context) {
        try {
            context.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + context.getPackageName())
                    )
            );
        } catch (ActivityNotFoundException anfe) {
            context.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())
                    )
            );
        }
    }

    public void showPolicy(Context context,String policyUrl) {
        openWeb(context, policyUrl);
    }

    public void openWeb(Context context, String url) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                    url)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void log(String text) {
        Log.d(TAG, text);
    }


    public void saveFile(InputStream fin, String savePath, String nameFile) {
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(new File(savePath + "/" + nameFile));
            int lenght = 0;
            byte buff[] = new byte[1024];
            lenght = fin.read(buff);
            while (lenght > 0) {
                fout.write(buff, 0, lenght);
                lenght = fin.read(buff);
            }
            fin.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String formatTime(long duration) {
        return formatTime(duration, false);
    }

    public String formatTime(long duration, boolean isHour) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        if (!isHour) {
            formatter = new SimpleDateFormat("mm:ss");
        }
        Date date = new Date(duration);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public String formatDate(long duration) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(duration);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public void shareFile(Context context, File file) {
        try {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            Intent intentShareFile = new Intent(Intent.ACTION_SEND);
            intentShareFile.setType(URLConnection.guessContentTypeFromName(file.getName()));
            intentShareFile.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file://" + file.getAbsolutePath()));
            context.startActivity(Intent.createChooser(intentShareFile, "Share File"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
