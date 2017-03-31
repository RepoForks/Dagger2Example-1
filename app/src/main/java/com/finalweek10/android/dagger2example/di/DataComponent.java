package com.finalweek10.android.dagger2example.di;

import com.finalweek10.android.dagger2example.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 2017/3/30.
 * Hello, friend.
 */


@Singleton
@Component(modules = DataModule.class)
public interface DataComponent {
    void inject(MainActivity mainActivity);
}
