package com.example.fr9b.betterskistar.fragments;

import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.SeasonFragmentBinding;
import com.example.fr9b.betterskistar.viewmodels.SeasonFragmentViewModel;


/**
 * Created by fr9b on 2018-02-04.
 */

public class SeasonFragment extends Fragment {

    private String title;
    private int page;
    private SeasonFragmentViewModel viewModel = new SeasonFragmentViewModel();

    // newInstance constructor for creating fragment with arguments
    public static SeasonFragment newInstance(int page, String title) {
        SeasonFragment fragmentSeason = new SeasonFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSeason.setArguments(args);
        return fragmentSeason;
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

        SeasonFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.season_fragment, container, false);
        binding.setViewModel(viewModel);


        View view = inflater.inflate(R.layout.season_fragment, container, false);
        //TextView tvLabel = (TextView) view.findViewById(R.id.textView3);
        //tvLabel.setText(page + " -- " + title);
        //return view;
        return binding.getRoot();
    }
}
