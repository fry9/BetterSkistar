package com.example.fr9b.betterskistar.fragments;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.AllTimeFragmentBinding;
import com.example.fr9b.betterskistar.viewmodels.AllTimeFragmentViewModel;

/**
 * Created by fr9b on 2018-02-04.
 */

public class AllTimeFragment extends Fragment {
    private String title;
    private int page;
    private AllTimeFragmentViewModel viewModel = new AllTimeFragmentViewModel();

    // newInstance constructor for creating fragment with arguments
    public static AllTimeFragment newInstance(int page, String title) {
        AllTimeFragment fragmentAllTime = new AllTimeFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentAllTime.setArguments(args);
        return fragmentAllTime;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        //viewModel.refreshSummary();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        AllTimeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.all_time_fragment, container, false);
        binding.setViewModel(viewModel);

        View view = inflater.inflate(R.layout.all_time_fragment, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView3);
        //tvLabel.setText(page + " -- " + title);
        //return view;
        return binding.getRoot();
    }
}
