package com.example.networkdesign.ListDesign.ListDesignService;

import com.example.networkdesign.ListDesign.Model.TrainApply;
import com.example.networkdesign.core.Network.HttpErrData;

import java.util.List;

public class GetTrainApplyRes {

    private List<TrainApply> plans;

    public List<TrainApply> getPlans() {
        return plans;
    }

    public void setPlans(List<TrainApply> plans) {
        this.plans = plans;
    }
}
