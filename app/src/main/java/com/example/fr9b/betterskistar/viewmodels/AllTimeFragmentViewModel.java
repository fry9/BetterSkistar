package com.example.fr9b.betterskistar.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.fr9b.betterskistar.BR;
import com.example.fr9b.betterskistar.models.SkistarSummary;
import com.example.fr9b.betterskistar.services.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fr9b on 2018-02-04.
 */

public class AllTimeFragmentViewModel extends BaseViewModel {

    @Override
    @Bindable
    public Integer getSummaryDropHeight() {
        if (super.getSummaryDropHeight() == null) {
            refreshData();
        }
        return super.getSummaryDropHeight();
    }

    @Override
    @Bindable
    public Integer getSummaryLiftRides() {
        if (super.getSummaryLiftRides() == null) {
            refreshData();
        }
        return super.getSummaryLiftRides();
    }

}
