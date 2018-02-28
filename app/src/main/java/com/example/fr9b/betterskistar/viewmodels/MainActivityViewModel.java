package com.example.fr9b.betterskistar.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.fr9b.betterskistar.BR;
import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.activities.MainActivity;
import com.example.fr9b.betterskistar.activities.SettingsActivity;
import com.example.fr9b.betterskistar.models.SkistarSummary;


/**
 * Created by fr9b on 2018-02-02.
 */

public class MainActivityViewModel extends BaseViewModel {

    private String firstName;
    private SkistarSummary summary;
    private String friendCount;
    private String pageTitle;


    @Bindable
    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
        notifyPropertyChanged(BR.pageTitle);
    }


    @Bindable
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void click(View v) {
        setFirstName(friendCount);
    }


    @Bindable
    public SkistarSummary getSummary() {
        return summary;
    }
    public void setSummary(SkistarSummary summary) {
        this.summary = summary;
        notifyPropertyChanged(BR.summary);
    }

    @Bindable
    public String getFriendCount() {
        return friendCount;
    }
    public void setFriendCount(String friendCount) {
        this.friendCount = friendCount;
        notifyPropertyChanged(BR.friendCount);
    }

    public void settingsBtn(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

}
