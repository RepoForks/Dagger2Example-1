package com.finalweek10.android.dagger2example.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.finalweek10.android.dagger2example.data.model.IssService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 2017/3/30.
 * Hello, friend.
 */


@Module
public class DataModule {
    private final static String BASE_URL = "http://api.open-notify.org";

    private Application mApplication;

    public DataModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    public IssService provideIssService(Retrofit retrofit) {
        return retrofit.create(IssService.class);
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }
}
