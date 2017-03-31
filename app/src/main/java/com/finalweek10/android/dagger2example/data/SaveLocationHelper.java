package com.finalweek10.android.dagger2example.data;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SaveLocationHelper {
    private static final String PREF_ISS_LOC = "iss_loc";

    private SharedPreferences mSharedPreferences;

    @Inject
    public SaveLocationHelper(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void put(String value) {
        mSharedPreferences.edit().putString(PREF_ISS_LOC, value).apply();
    }

    public String get(String defaultValue) {
        return mSharedPreferences.getString(PREF_ISS_LOC, defaultValue);
    }

    public void deleteSavedData() {
        mSharedPreferences.edit().remove(PREF_ISS_LOC).apply();
    }
}
