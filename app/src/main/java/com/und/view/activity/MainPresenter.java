package com.und.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;

import com.und.application.uApplication;
import com.und.core.Presenter.BasePresenter;

import java.util.Hashtable;


/**
 * Created by hungle on 01/03/2019.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    Hashtable<Integer, Integer> mCurrentItemOn
            = new Hashtable<Integer, Integer>();

    public MainPresenter(Context ctx) {
        super(ctx);

        /* inject the api server into the presenter */
        uApplication.component().inject(this);
    }

    @Override
    public void onDestroy() {

    }

    @SuppressLint("NewApi")
    @Override
    public void onChangeKeywordPosition(int itemCount, int index) {

        int pos = 0;

        if (mCurrentItemOn.get(index) == null){
            mCurrentItemOn.put(index, pos);
        }
        else if (mCurrentItemOn.get(index) == itemCount) {
            pos = 0;
        }
        else {
            pos = mCurrentItemOn.get(index) + 1;
        }
        mCurrentItemOn.replace(index, pos);
        getView().onChangeKeywordPosition(pos);
    }
}
