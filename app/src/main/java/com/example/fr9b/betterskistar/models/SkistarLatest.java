package com.example.fr9b.betterskistar.models;

/**
 * Created by fr9b on 2018-02-07.
 */

public class SkistarLatest {

    private LatestSeasonStatistics latestSeasonStatistics;
    private LatestWeekStatistics latestWeekStatistics;
    private LatestDayStatistics latestDayStatistics;

    public LatestSeasonStatistics getLatestSeasonStatistics() {
        return latestSeasonStatistics;
    }

    public void setLatestSeasonStatistics(LatestSeasonStatistics latestSeasonStatistics) {
        this.latestSeasonStatistics = latestSeasonStatistics;
    }

    public LatestWeekStatistics getLatestWeekStatistics() {
        return latestWeekStatistics;
    }

    public void setLatestWeekStatistics(LatestWeekStatistics latestWeekStatistics) {
        this.latestWeekStatistics = latestWeekStatistics;
    }

    public LatestDayStatistics getLatestDayStatistics() {
        return latestDayStatistics;
    }

    public void setLatestDayStatistics(LatestDayStatistics latestDayStatistics) {
        this.latestDayStatistics = latestDayStatistics;
    }

}
