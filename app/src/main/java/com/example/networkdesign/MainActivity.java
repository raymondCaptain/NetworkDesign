package com.example.networkdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.networkdesign.NetworkDesign.View.NetworkDesignActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void toNetworkDesignModular() {
        NetworkDesignActivity.start(this);
    }
}
