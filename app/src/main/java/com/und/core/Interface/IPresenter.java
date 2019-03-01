package com.und.core.Interface;

import com.und.core.Layout.activity.uBaseActivity;

/**
 * Created by hungle on 01/03/2019.
 */

public interface IPresenter {

    void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls);
}
