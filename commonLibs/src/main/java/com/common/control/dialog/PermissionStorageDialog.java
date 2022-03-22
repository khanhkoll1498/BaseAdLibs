package com.common.control.dialog;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.common.control.R;
import com.common.control.utils.PermissionPrefData;
import com.common.control.utils.PermissionUtils;


public class PermissionStorageDialog extends AppCompatActivity implements View.OnClickListener {

    private static final String NOT_SHOW_AGAIN = "not_show_again";

    private boolean isStartSettingPermission;

    public static void show(Activity context, String content) {
        Intent intent = new Intent(context, PermissionStorageDialog.class);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_storage);
        String content = getIntent().getStringExtra("content");
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(content);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (this.isStartSettingPermission) {
            if (PermissionUtils.isStoragePermissionGranted(this) && PermissionUtils.instance().getPermissionCallback() != null) {
                PermissionUtils.instance().getPermissionCallback().onPermissionGranted();
                finish();
                this.isStartSettingPermission = false;
            }
        }
    }

    private void initViews() {
        findViewById(R.id.bt_deny).setOnClickListener(this);
        findViewById(R.id.bt_grant).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_deny) {
            finish();
            return;
        }
        if (id == R.id.bt_grant) {
            PermissionUtils.instance().requestPermission(this);
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PermissionUtils.instance().onActivityResult(this, requestCode);
        if (PermissionUtils.isStoragePermissionGranted(this)) {
            finish();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != PermissionUtils.RQC_REQUEST_PERMISSION_ANDROID_BELOW) {
            return;
        }

        PermissionPrefData instance = PermissionPrefData.instance(this);
        for (String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                continue;
            }
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
                if (permission.equals(WRITE_EXTERNAL_STORAGE) && PermissionUtils.instance().getPermissionCallback() != null) {
                    PermissionUtils.instance().getPermissionCallback().onPermissionGranted();
                    finish();
                    return;
                }
            } else if (permission.equals(WRITE_EXTERNAL_STORAGE)) {
                instance.putBoolean(NOT_SHOW_AGAIN, true);
            }
        }

        if (instance.getBoolean(NOT_SHOW_AGAIN, false)) {
            PermissionUtils.showDialogPermission(this);
            isStartSettingPermission = true;
            return;
        }
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!PermissionUtils.isStoragePermissionGranted(this)) {
            try {
                PermissionUtils.instance().getPermissionCallback().onPermissionAborted();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
