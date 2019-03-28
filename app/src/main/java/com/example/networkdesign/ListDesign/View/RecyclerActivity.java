package com.example.networkdesign.ListDesign.View;
// 所有包名不要带大写 ListDesign Adapter ...

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.networkdesign.ListDesign.Adapter.TrainApplyAdapter;
import com.example.networkdesign.ListDesign.ListDesignService.GetTrainApplyRes;
import com.example.networkdesign.ListDesign.ListDesignService.RecyclerService;
import com.example.networkdesign.R;
import com.example.networkdesign.core.Network.ZWHttp;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerService service = ZWHttp.createService(RecyclerService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_activity);

        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        refrsh();
    }

    static public void start(Context context) {
        Intent intent = new Intent(context, RecyclerActivity.class);
        context.startActivity(intent);
    }

    @OnClick(R.id.refreshButton)
    void refrsh() {
        HashMap<String, String> map = ZWHttp.newBody();
        map.put("status", "");
        ZWHttp.observe(this, service.getTopMovie(map), new Consumer<GetTrainApplyRes>() {
            @Override
            public void accept(GetTrainApplyRes getTrainApplyRes) throws Exception {
                recyclerView.setAdapter(new TrainApplyAdapter(getTrainApplyRes.getPlans()));
            }
        });
    }
}
