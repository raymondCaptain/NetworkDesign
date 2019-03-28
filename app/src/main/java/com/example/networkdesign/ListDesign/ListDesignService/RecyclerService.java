package com.example.networkdesign.ListDesign.ListDesignService;

import com.example.networkdesign.core.Network.ZWHttpResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.HashMap;

public interface RecyclerService {
    @POST("train/TrainApply/getTrainApply.php")
    Observable<ZWHttpResult<GetTrainApplyRes>> getTopMovie(@Body HashMap body);
}