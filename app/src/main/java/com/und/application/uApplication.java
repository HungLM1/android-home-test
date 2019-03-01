package com.und.application;

import android.app.Application;

import com.und.dagger.Interface.IDependencyService;

import io.realm.Realm;

/**
 * Created by hungle on 01/03/2019.
 */

public class uApplication extends Application {

    private static final String TAG = "uApplication";

    static uApplication mInstance;

    static IDependencyService mDependencyService;

    public static uApplication instance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        Realm.init(this);

        InitDependencyService();

        component().inject(this);
    }

    void InitDependencyService() {

        mDependencyService = IDependencyService.Initializer.init(this);
    }

    public static IDependencyService component() {

        return mDependencyService;
    }
}
