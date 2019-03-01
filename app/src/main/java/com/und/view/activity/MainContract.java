package com.und.view.activity;


import com.und.core.Interface.IBaseView;
import com.und.core.Layout.activity.uBaseActivity;

/**
 * Created by hungle on 01/03/2019.
 */

public interface MainContract {
    interface View extends IBaseView {

        void onChangeKeywordPosition(int pos);
    }

    interface Presenter{

        void onDestroy();

        void onChangeKeywordPosition(int itemCount, int index);
    }
}
