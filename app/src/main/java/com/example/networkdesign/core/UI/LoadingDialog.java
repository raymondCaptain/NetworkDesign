package com.example.networkdesign.core.UI;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.networkdesign.R;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context, R.style.TransparentDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_dialog);
    }
}
