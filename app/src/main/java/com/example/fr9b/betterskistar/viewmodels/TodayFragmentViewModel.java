package com.example.fr9b.betterskistar.viewmodels;

import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by fr9b on 2018-02-04.
 */

public class TodayFragmentViewModel extends BaseViewModel {


    @Override
    @Bindable
    public Integer getDayTotalDropHeight() {
        Log.e("getDayTotalDropHeight", super.getDayTotalDropHeight() + "");
        if (super.getDayTotalDropHeight() == null) {
            refreshData();
        }
        return super.getDayTotalDropHeight();
    }

    @Override
    @Bindable
    public Integer getDayTotalRides() {
        Log.e("getDayTotalRides", super.getDayTotalRides() + "");
        if (super.getDayTotalRides() == null) {
            refreshData();
        }
        return super.getDayTotalRides();
    }
}

