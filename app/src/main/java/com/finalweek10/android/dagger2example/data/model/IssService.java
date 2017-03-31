package com.finalweek10.android.dagger2example.data.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created on 2017/3/28.
 * Hello, friend.
 */


public interface IssService {
    @GET("/iss-now.json")
    Call<IssNow> getIssNow();
}
