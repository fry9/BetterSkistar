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
import com.example.fr9b.betterskistar.databinding.SettingsActivityBinding;
import com.example.fr9b.betterskistar.viewmodels.SettingsActivityViewModel;

/**
 * Created by fr9b on 2018-02-13.
 */

public class SettingsActivity extends AppCompatActivity {

    private SettingsActivityViewModel viewModel = new SettingsActivityViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SettingsActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.settings_activity);
        binding.setViewModel(viewModel);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.parseColor("#fc8d71"));


    }

}
