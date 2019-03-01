package com.und.core.Interface;

import android.os.Bundle;

import com.und.core.Layout.activity.uBaseActivity;

/**
 * Created by hungle on 01/03/2019.
 */

public interface IBaseView {

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String message);

    void showMessage(String message);

    void openActivity(Class<? extends uBaseActivity> cls);

    void openActivity(Class<? extends uBaseActivity> cls, Bundle bundle);

    void openActivityForResult(Class<? extends uBaseActivity> cls, Bundle bundle, int req_code);

    void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls);

    void showLoadingView();

    void hideLoadingView();

    void finish();
}
