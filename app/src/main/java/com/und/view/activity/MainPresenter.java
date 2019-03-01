package com.und.view.activity;

import android.content.Context;
import android.os.Handler;

import com.und.application.uApplication;
import com.und.core.Presenter.BasePresenter;


/**
 * Created by hungle on 01/03/2019.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(Context ctx) {
        super(ctx);

        /* inject the api server into the presenter */
        uApplication.component().inject(this);

    }

    @Override
    public void onDestroy() {

    }
}
