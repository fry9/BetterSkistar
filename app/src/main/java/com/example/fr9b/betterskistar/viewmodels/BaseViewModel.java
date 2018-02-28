package com.example.fr9b.betterskistar.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;

import com.example.fr9b.betterskistar.BR;
import com.example.fr9b.betterskistar.activities.MainActivity;
import com.example.fr9b.betterskistar.models.SkistarLatest;
import com.example.fr9b.betterskistar.models.SkistarSummary;
import com.example.fr9b.betterskistar.services.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fr9b on 2018-02-07.
 */

public class BaseViewModel extends BaseObservable {

    private static SkistarLatest latest;
    private SwipeRefreshLayout swipeContainer;
    private Integer dayTotalDropHeight;
    private Integer dayTotalRides;
    private Integer weekTotalDropHeight;
    private Integer weekTotalRides;
    private Integer seasonTotalDropHeight;
    private Integer seasonTotalRides;

    private static SkistarSummary summary;
    private Integer summaryDropHeight;
    private Integer summaryLiftRides;
    private String skistarId;

    private boolean refreshLatestSwipeDone = false;
    private boolean refreshSummarySwipeDone = false;


    public void setDayTotalDropHeight(int dayTotalDropHeight) {
        this.dayTotalDropHeight = dayTotalDropHeight;
        notifyPropertyChanged(BR.dayTotalDropHeight);
    }
    public Integer getDayTotalDropHeight() {
        return dayTotalDropHeight;
    }

    public void setDayTotalRides(int dayTotalRides) {
        this.dayTotalRides = dayTotalRides;
        notifyPropertyChanged(BR.dayTotalRides);
    }
    public Integer getDayTotalRides() {
        return dayTotalRides;
    }

    public Integer getWeekTotalDropHeight() {
        return weekTotalDropHeight;
    }
    public void setWeekTotalDropHeight(Integer weekTotalDropHeight) {
        this.weekTotalDropHeight = weekTotalDropHeight;
        notifyPropertyChanged(BR.weekTotalDropHeight);
    }

    public Integer getWeekTotalRides() {
        return weekTotalRides;
    }
    public void setWeekTotalRides(Integer weekTotalRides) {
        this.weekTotalRides = weekTotalRides;
        notifyPropertyChanged(BR.weekTotalRides);
    }

    public Integer getSeasonTotalDropHeight() {
        return seasonTotalDropHeight;
    }
    public void setSeasonTotalDropHeight(Integer seasonTotalDropHeight) {
        this.seasonTotalDropHeight = seasonTotalDropHeight;
        notifyPropertyChanged(BR.seasonTotalDropHeight);
    }

    public Integer getSeasonTotalRides() {
        return seasonTotalRides;
    }
    public void setSeasonTotalRides(Integer seasonTotalRides) {
        this.seasonTotalRides = seasonTotalRides;
        notifyPropertyChanged(BR.seasonTotalRides);
    }

    public void setSummaryDropHeight(Integer summaryDropHeight) {
        this.summaryDropHeight = summaryDropHeight;
        notifyPropertyChanged(BR.summaryDropHeight);
    }
    public Integer getSummaryDropHeight() {
        return summaryDropHeight;
    }

    public void setSummaryLiftRides(Integer summaryLiftRides) {
        this.summaryLiftRides = summaryLiftRides;
        notifyPropertyChanged(BR.summaryLiftRides);
    }
    public Integer getSummaryLiftRides() {
        return summaryLiftRides;
    }

    public void setSwipeContainer(SwipeRefreshLayout swipeContainer) {
        this.swipeContainer = swipeContainer;
    }

    public void refreshData() {
        if (latest != null && summary != null) {
            setDayTotalDropHeight(latest.getLatestDayStatistics().getDropHeight());
            setDayTotalRides(latest.getLatestDayStatistics().getLiftRides());

            setWeekTotalDropHeight(latest.getLatestWeekStatistics().getDropHeight());
            setWeekTotalRides(latest.getLatestWeekStatistics().getDayCount());

            setSeasonTotalDropHeight(latest.getLatestSeasonStatistics().getDropHeight());
            setSeasonTotalRides(latest.getLatestSeasonStatistics().getLiftRides());

            setSummaryDropHeight(summary.getDropHeight());
            setSummaryLiftRides(summary.getLiftRides());
            Log.e("refreshData done", "OK");
        }
        notifyPropertyChanged(BR._all);
    }

    public void refreshSkistarId(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        skistarId = preferences.getString("id", "");
        //3206
    }

    public void swipeRefreshDoneNotifyer () {
        if (refreshLatestSwipeDone && refreshSummarySwipeDone) {
            swipeContainer.setRefreshing(false);
            refreshLatestSwipeDone = false;
            refreshSummarySwipeDone = false;
        }
    }

    public void refreshLatest() {
        Services.getService().latestStatistics(skistarId).enqueue(new Callback<SkistarLatest>() {
            @Override
            public void onResponse(Call<SkistarLatest> call, Response<SkistarLatest> response) {
                latest = response.body();
                if (swipeContainer != null) {
                    refreshLatestSwipeDone = true;
                    swipeRefreshDoneNotifyer();
                }
                Log.e("New API response", "SKISTAR LATEST");
                refreshData();
            }

            @Override
            public void onFailure(Call<SkistarLatest> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });

    }

    public void refreshSummary() {
        Services.getService().summary(skistarId).enqueue(new Callback<SkistarSummary>() {
            @Override
            public void onResponse(Call<SkistarSummary> call, Response<SkistarSummary> response) {
                summary = response.body();
                if (swipeContainer != null) {
                    refreshSummarySwipeDone = true;
                    swipeRefreshDoneNotifyer();
                }
                refreshData();
                Log.e("New API response", "SKISTAR SUMMARY");
            }

            @Override
            public void onFailure(Call<SkistarSummary> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });

    }

}
