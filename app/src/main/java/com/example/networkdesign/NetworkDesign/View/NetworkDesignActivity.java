package com.example.networkdesign.NetworkDesign.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.networkdesign.ListDesign.View.RecyclerActivity;
import com.example.networkdesign.NetworkDesign.NetworkDesignService.GetTopMovieRes;
import com.example.networkdesign.NetworkDesign.NetworkDesignService.NetworkDesignService;
import com.example.networkdesign.R;
import com.example.networkdesign.core.Network.ZWHttp;
import com.example.networkdesign.core.UI.LoadingDialog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class NetworkDesignActivity extends AppCompatActivity {

    private static final String TAG = "NetworkDesignActivity";

    @BindView(R.id.textView)
    protected TextView textView;

    final private NetworkDesignService servie = ZWHttp.createService(NetworkDesignService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_design);
        ButterKnife.bind(this);
    }

    static public void start(Context context) {
        Intent intent = new Intent(context, NetworkDesignActivity.class);
        context.startActivity(intent);
    }

    @OnClick(R.id.button)
    void getMovie() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("clientType", "WinForm");
        map.put("innerIp", "167");
        map.put("note", "android测试");
        ZWHttp.observe(this, servie.getTopMovie(map), new Observer<GetTopMovieRes>() {
            @Override
            public void onSubscribe(Disposable d) {
//                Toast.makeText(NetworkDesignActivity.this, "onSubscribe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(GetTopMovieRes result) {
                GetTopMovieRes trd = result;
//                Toast.makeText(NetworkDesignActivity.this, "onNext>>" + string, Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onNext: 111>>>>>" + string);

//                try {
//                    String string = responseBody.string();
//                    Toast.makeText(NetworkDesignActivity.this, "onNext>>" + string, Toast.LENGTH_SHORT).show();
//                    Log.d(TAG, "onNext: 111>>>>>" + string);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError(Throwable e) {
                Throwable a = e;
//                Toast.makeText(NetworkDesignActivity.this, "onError>>" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
//                Toast.makeText(NetworkDesignActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onComplete: ");
            }
        });
    }

    @OnClick(R.id.button2)
    public void showDialog() {
        ProgressDialog waitingDialog = new ProgressDialog(this, R.style.TransparentDialog);
        waitingDialog.setMessage("加载中...");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
    }

    @OnClick(R.id.button3)
    public void showDialog2() {
        LoadingDialog waitingDialog = new LoadingDialog(this);
//        waitingDialog.setMessage("加载中...");
        waitingDialog.setCancelable(true);
//        waitingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        waitingDialog.show();
    }

    @OnClick(R.id.button4)
    public void goList() {
        RecyclerActivity.start(this);
    }
}
