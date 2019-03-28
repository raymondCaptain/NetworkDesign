package com.example.networkdesign.NetworkDesign.NetworkDesignService;


import com.example.networkdesign.core.Network.ZWHttpResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.HashMap;

public interface NetworkDesignService {
    @POST("test/testTwo.php")
    Observable<ZWHttpResult<GetTopMovieRes>> getTopMovie(@Body HashMap body);
}
