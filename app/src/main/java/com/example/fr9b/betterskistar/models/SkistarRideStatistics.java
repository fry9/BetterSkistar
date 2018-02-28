package com.example.fr9b.betterskistar.models;

/**
 * Created by fr9b on 2018-02-05.
 */

public class SkistarRideStatistics {

    private String date;
    private String liftName;
    private Integer dropHeight;
    private String timestamp;


    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setLiftName(String liftName) {
        this.liftName = liftName;
    }
    public String getLiftName() {
        return liftName;
    }

    public void setDropHeight(Integer dropHeight) {
        this.dropHeight = dropHeight;
    }
    public Integer getDropHeight() {
        return dropHeight;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getTimestamp() {
        return timestamp;
    }

}
