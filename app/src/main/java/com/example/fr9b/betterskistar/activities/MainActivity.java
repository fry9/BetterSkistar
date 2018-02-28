package com.example.fr9b.betterskistar.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.fr9b.betterskistar.R;
import com.example.fr9b.betterskistar.databinding.ActivityMainBinding;
import com.example.fr9b.betterskistar.fragments.AllTimeFragment;
import com.example.fr9b.betterskistar.fragments.SeasonFragment;
import com.example.fr9b.betterskistar.fragments.TodayFragment;
import com.example.fr9b.betterskistar.fragments.WeekFragment;
import com.example.fr9b.betterskistar.viewmodels.AllTimeFragmentViewModel;
import com.example.fr9b.betterskistar.viewmodels.MainActivityViewModel;

    public class MainActivity extends AppCompatActivity {

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TodayFragment.newInstance(0, "Day page");
                case 1:
                    return WeekFragment.newInstance(1, "Week page");
                case 2:
                    return SeasonFragment.newInstance(2, "Season page");
                case 3:
                    return AllTimeFragment.newInstance(3, "All time page");
                default:
                    return null;
            }
        }

    }

    FragmentPagerAdapter adapterViewPager;

    private MainActivityViewModel viewModel = new MainActivityViewModel();
    private AllTimeFragmentViewModel AllTimeviewModel = new AllTimeFragmentViewModel();
    ViewPager vpPager;
    private String[] PageTitles;
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private SwipeRefreshLayout swipeContainer;

    //Animation pageTitleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.parseColor("#fc8d71"));


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager = (ViewPager) findViewById(R.id.vpPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(vpPager, true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PageTitles = getResources().getStringArray(R.array.page_titles);
        viewModel.setPageTitle(PageTitles[0]);

        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //assert recyclerView != null;
        //setupRecyclerView((RecyclerView) recyclerView);

        ConnectivityManager cm = (ConnectivityManager)vpPager.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        if(isConnected) {
            viewModel.refreshSkistarId(vpPager.getContext());
            viewModel.refreshLatest();
            viewModel.refreshSummary();
        }


        vpPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled( int position, float v, int i1 ) {
            }

            @Override
            public void onPageSelected( int position ) {
               viewModel.setPageTitle(PageTitles[position]);

                TextView vi = findViewById(R.id.textViewTitle);
                Animation animation = AnimationUtils.loadAnimation(vpPager.getContext(), R.anim.toolbar_text_animation);
                vi.startAnimation(animation);
            }

            @Override
            public void onPageScrollStateChanged( int state ) {
                enableDisableSwipeRefresh( state == ViewPager.SCROLL_STATE_IDLE );
            }
        } );

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("New refresh..", "");
                viewModel.refreshSkistarId(vpPager.getContext());
                viewModel.setSwipeContainer(swipeContainer);
                viewModel.refreshLatest();
                viewModel.refreshSummary();
            }
        });
        swipeContainer.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorPrimary,
                R.color.dark,
                R.color.darker);

        //schedulePeriodicJob();

    }


    private void enableDisableSwipeRefresh(boolean enable) {
        if (swipeContainer != null && !swipeContainer.isRefreshing()) {
            swipeContainer.setEnabled(enable);
        }
    }


    /*
    private void schedulePeriodicJob() {
        JobScheduler jobScheduler =
                (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        jobScheduler.schedule(new JobInfo.Builder(1234,
                new ComponentName(this, UpdateSkierStats.class))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPeriodic(15 * 60000)
                .build());
    }
    */

}


