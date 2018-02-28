package com.example.fr9b.betterskistar.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.TodayFragmentBinding;
import com.example.fr9b.betterskistar.viewmodels.TodayFragmentViewModel;


/**
 * Created by fr9b on 2018-02-03.
 */

public class TodayFragment extends Fragment {
    private String title;
    private int page;
    private TodayFragmentViewModel viewModel = new TodayFragmentViewModel();

    // newInstance constructor for creating fragment with arguments
    public static TodayFragment newInstance(int page, String title) {
        TodayFragment fragmentToday = new TodayFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentToday.setArguments(args);
        return fragmentToday;
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

        TodayFragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.today_fragment, container, false);

        binding.setViewModel(viewModel);

        View view = inflater.inflate(R.layout.today_fragment, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView3);
        //tvLabel.setText(page + " -- " + title);
        //return view;
        return binding.getRoot();
    }

}
