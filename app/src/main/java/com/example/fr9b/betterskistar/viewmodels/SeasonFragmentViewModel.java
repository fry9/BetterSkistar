package com.example.fr9b.betterskistar.viewmodels;

import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by fr9b on 2018-02-04.
 */

public class SeasonFragmentViewModel extends BaseViewModel {

    @Override
    @Bindable
    public Integer getSeasonTotalDropHeight() {
        Log.e("getSeasonTotalDropHeight", super.getSeasonTotalDropHeight() + "");
        if (super.getSeasonTotalDropHeight() == null) {
            refreshData();
        }
        return super.getSeasonTotalDropHeight();
    }

    @Override
    @Bindable
    public Integer getSeasonTotalRides() {
        Log.e("getSeasonTotalRides", super.getSeasonTotalRides() + "");
        if (super.getSeasonTotalRides() == null) {
            refreshData();
        }
        return super.getSeasonTotalRides();
    }
}
