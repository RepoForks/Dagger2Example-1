package com.finalweek10.android.dagger2example;

import android.app.Application;
import android.content.Context;

import com.finalweek10.android.dagger2example.di.DaggerDataComponent;
import com.finalweek10.android.dagger2example.di.DataComponent;
import com.finalweek10.android.dagger2example.di.DataModule;

/**
 * Created on 2017/3/30.
 * Hello, friend.
 */


public class ExampleApplication extends Application {

    protected DataComponent dataComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dataComponent = DaggerDataComponent.builder()
                .dataModule(new DataModule(this))
                .build();
    }

    public DataComponent getDataComponent() {
        return dataComponent;
    }

    public static ExampleApplication getApplication(Context context) {
        return (ExampleApplication) context.getApplicationContext();
    }
}
