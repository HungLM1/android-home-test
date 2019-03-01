package com.und.core.Presenter;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

//import javax.inject.Inject;
//
//import com.und.api.BDSApiService;
import com.und.core.Interface.IBaseView;

/**
 * Created by hungle on 01/03/2019.
 */

public  class BasePresenter<T extends IBaseView> {
    public String TAG = "BasePresenter";

//    @Inject
//    public BDSApiService mApiService = new BDSApiService();

    protected Context mContext;

    WeakReference<T> mView;
    AtomicBoolean isViewAlive = new AtomicBoolean();

    public void setView(T view) {
        this.mView = new WeakReference<T>(view);
    }

    public T getView() {
        return mView.get();
    }

    public void start() {
        isViewAlive.set(true);
    }

    public void finalize() {
        isViewAlive.set(false);
    }

    public BasePresenter(Context ctx) {
        this.mContext = ctx;
    }


}
