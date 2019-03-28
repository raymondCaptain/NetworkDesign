package com.example.networkdesign.core.Network;

public class ZWHttpResult<T> {

    /**
     * isSuccess : false
     * data : {}
     * errData : {"errmsg":"测试","file":"E:\\WWW\\code\\developzw\\sdtjyLP\\train\\TrainApply\\GetTrainApply.php","line":78}
     */

    private boolean isSuccess;
    private T data;
    private HttpErrData errData;

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpErrData getErrData() { return errData; }

    public void setErrData(HttpErrData errData) { this.errData = errData; }


}
