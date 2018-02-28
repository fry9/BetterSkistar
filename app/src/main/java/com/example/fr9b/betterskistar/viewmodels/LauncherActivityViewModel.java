package com.example.fr9b.betterskistar.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.fr9b.betterskistar.BR;
import com.example.fr9b.betterskistar.activities.LauncherActivity;
import com.example.fr9b.betterskistar.activities.MainActivity;

/**
 * Created by fr9b on 2018-02-09.
 */

public class LauncherActivityViewModel extends BaseObservable {

    private String skistarId = "Your Skistar id";
    private boolean enableBtn = false;
    private Integer alphaBtn = 0;

    @Bindable
    public Integer getAlphaBtn() {
        return alphaBtn;
    }

    @Bindable
    public String getSkistarId() {
        return skistarId;
    }
    public void setSkistarId(String skistarId) {

        if(skistarId.matches("\\d+(?:\\.\\d+)?") && Integer.parseInt(skistarId) > 100) {
            this.skistarId = skistarId;
            alphaBtn = 1;
            enableBtn = true;
        } else {
            alphaBtn = 0;
            enableBtn = false;
        }
        notifyPropertyChanged(BR.alphaBtn);
        notifyPropertyChanged(BR.enableBtn);
    }

    @Bindable
    public boolean isEnableBtn() {
        return enableBtn;
    }
    public void setEnableBtn(boolean enableBtn) {
        this.enableBtn = enableBtn;
    }

    public void nextBtn(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, MainActivity.class);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("id",skistarId);
        editor.apply();

        context.startActivity(intent);
    }



}
