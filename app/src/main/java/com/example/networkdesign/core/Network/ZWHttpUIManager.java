package com.example.networkdesign.core.Network;

import android.content.Context;


import com.example.networkdesign.core.UI.LoadingDialog;

public class ZWHttpUIManager {
    private LoadingDialog loadingDialog;

    public void showLoading(Context context) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.setCancelable(false);
        loadingDialog.show();

        this.loadingDialog = loadingDialog;
    }

    public void hide() {
//        loadingDialog.hide();
        loadingDialog.dismiss();
    }
}
