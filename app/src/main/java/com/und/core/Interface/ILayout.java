package com.und.core.Interface;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.und.core.Layout.activity.uBaseActivity;

/**
 * Created by hungle on 01/03/2019.
 */

public interface ILayout {
    void onLoad();

    void onCreateView();

    @LayoutRes
    int layout();

    void showProgressDialog();

    void hideProgressDialog();

    void hideLoadingView();

    void showLoadingView();

    void openActivity(Class<? extends uBaseActivity> cls);

    void openActivity(Class<? extends uBaseActivity> cls, Bundle bundle);

    void openActivityForResult(Class<? extends uBaseActivity> cls, Bundle bundle, int req_code);

    void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls);

    void finish();

}
