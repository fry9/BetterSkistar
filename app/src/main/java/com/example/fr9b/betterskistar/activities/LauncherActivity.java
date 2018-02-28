package com.example.fr9b.betterskistar.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.ActivityMainBinding;
import com.example.fr9b.betterskistar.viewmodels.LauncherActivityViewModel;
import com.example.fr9b.betterskistar.databinding.LauncherActivityBinding;
import com.q42.android.scrollingimageview.ScrollingImageView;

/**
 * Created by fr9b on 2018-02-03.
 */

public class LauncherActivity extends AppCompatActivity {

    private LauncherActivityViewModel viewModel = new LauncherActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LauncherActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.launcher_activity);
        binding.setViewModel(viewModel);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.parseColor("#fc8d71"));


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String id = preferences.getString("id", "");

        if(!id.equalsIgnoreCase("")) {
            //SharedPreferences.Editor editor = preferences.edit();
            //editor.putString("ID","3206");
            //editor.apply();
            startActivity(new Intent(LauncherActivity.this, MainActivity.class));
        }

    }
}
