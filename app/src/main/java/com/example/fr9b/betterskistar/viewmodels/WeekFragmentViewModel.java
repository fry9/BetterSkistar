package com.example.fr9b.betterskistar.viewmodels;

import android.databinding.Bindable;
import android.util.Log;


/**
 * Created by fr9b on 2018-02-04.
 */

public class WeekFragmentViewModel extends BaseViewModel {

    //ta bort och bara ha i super?
    @Override
    @Bindable
    public Integer getWeekTotalDropHeight() {
        Log.e("getWeekTotalDropHeight", super.getWeekTotalDropHeight() + "");
        if (super.getWeekTotalDropHeight() == null) {
            refreshData();
        }
        return super.getWeekTotalDropHeight();
    }

    @Override
    @Bindable
    public Integer getWeekTotalRides() {
        Log.e("getWeekTotalDropHeight", super.getWeekTotalDropHeight() + "");
        if (super.getWeekTotalDropHeight() == null) {
            refreshData();
        }
        return super.getWeekTotalRides();
    }

}
