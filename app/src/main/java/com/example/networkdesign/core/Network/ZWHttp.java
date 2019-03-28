package com.example.networkdesign.core.Network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;

import com.example.networkdesign.core.Log.ZWLog;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZWHttp {
    private static final String TAG = "ZWHttp";

    public static <T> T createService(Class<T> Service) {
        String baseUrl = "https://www.sdtjywx.cn:8443/code/developzw/sdtjyLP/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Service);
    }

    public static HashMap<String, String> newBody() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("clientType", "WinForm");
        map.put("innerIp", "167");
        map.put("userId", "167");
        return map;
    }

    public static <T> void observe(Context context, Observable<ZWHttpResult<T>> observable, Consumer<T> onNext) {
        observe(context, observable, onNext, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception { }
        });
    }

    public static <T> void observe(Context context, Observable<ZWHttpResult<T>> observable, Consumer<T> onNext, Consumer<Throwable> onError) {
        createHttpObserve(context, observable)
                .subscribe(onNext, onError);
    }

    public static <T> void observe(Context context, Observable<ZWHttpResult<T>> observable, Observer<T> observer) {
        createHttpObserve(context, observable)
                .subscribe(observer);
    }

    private static <T> Observable<T> createHttpObserve(Context context, Observable<ZWHttpResult<T>> observable) {
        ZWHttpUIManager uiManager = new ZWHttpUIManager();
        uiManager.showLoading(context);

        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(new Consumer<Notification<ZWHttpResult<T>>>() {
                    @Override
                    public void accept(Notification<ZWHttpResult<T>> zwHttpResultNotification) throws Exception {
                        uiManager.hide();
                    }
                })
                .map(new ResultParse<>());
    }

    private static class ResultParse<T> implements Function<ZWHttpResult<T>, T> {
        @Override
        public T apply(ZWHttpResult<T> result) throws Exception {
            if (result.isIsSuccess()) {
                return result.getData();
            } else {
                if (result.getErrData().getLine() != null) {
                    String errmsg = result.getErrData().getErrmsg();
                    String file = result.getErrData().getFile();
                    String line = result.getErrData().getLine();
                    throw new Exception(errmsg + ", in file:" + file + ", on line:" + line);
                } else {
                    throw new Exception(result.getErrData().getErrmsg());
                }
            }
        }
    }
}
