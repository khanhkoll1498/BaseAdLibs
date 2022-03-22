package com.common.control.interfaces;

public interface PermissionCallback {
    void onPermissionNotGranted();

    void onPermissionGranted();

    void onPermissionDenied();

    void onPermissionAborted();

}
