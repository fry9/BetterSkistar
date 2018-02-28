package com.example.fr9b.betterskistar.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fr9b on 2018-02-08.
 */

public class UpdateSkierStats extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d("SKISTAR", "onStartJob called");
        jobFinished(jobParameters,false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
