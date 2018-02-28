package com.example.fr9b.betterskistar.services;

import com.example.fr9b.betterskistar.models.SkistarLatest;
import com.example.fr9b.betterskistar.models.SkistarRideStatistics;
import com.example.fr9b.betterskistar.models.SkistarSummary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by fr9b on 2018-02-03.
 */

public interface SkistarAPIService {

    @GET("statistic/summary")
    Call<SkistarSummary> summary(@Header("DisplayedEntityId") String skierId);
    @GET("statistic/rides?seasonId=13")
    Call<List<SkistarRideStatistics>> statistics(@Header("DisplayedEntityId") String skierId);
    @GET("statistic/latest")
    Call<SkistarLatest> latestStatistics(@Header("DisplayedEntityId") String skierId);
}

/*
https://www.skistar.com/myskistar/game/api/v3/statistic/rides?seasonId=13
https://www.skistar.com/myskistar/game/api/v3/pins/latest?seasonId=13
https://www.skistar.com/myskistar/game/api/v3/statistic/active
https://www.skistar.com/myskistar/game/api/v3/statistic/summary
https://www.skistar.com/myskistar/game/api/v3/statistic/latest
https://www.skistar.com/myskistar/game/api/v3/friend/count
https://www.skistar.com/myskistar/game/api/v3/position
https://www.skistar.com/myskistar/game/api/v3/position/friend
https://www.skistar.com/myskistar/game/api/v3/leaderboard/friends/latest
*/