package com.example.fr9b.betterskistar.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.WeekFragmentBinding;
import com.example.fr9b.betterskistar.viewmodels.WeekFragmentViewModel;

/**
 * Created by fr9b on 2018-02-03.
 */

public class WeekFragment extends Fragment {
    private String title;
    private int page;
    private WeekFragmentViewModel viewModel = new WeekFragmentViewModel();

    // newInstance constructor for creating fragment with arguments
    public static WeekFragment newInstance(int page, String title) {
        WeekFragment fragmentWeek = new WeekFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentWeek.setArguments(args);
        return fragmentWeek;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        viewModel.refreshData();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WeekFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.week_fragment, container, false);

        binding.setViewModel(viewModel);

        View view = inflater.inflate(R.layout.week_fragment, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView5);
        //tvLabel.setText(page + " -- " + title);
        //return view;
        return binding.getRoot();
    }
}
