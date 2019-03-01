package com.und.core.Layout.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.und.R;
import com.und.core.Interface.IBaseFragment;
import com.und.core.Presenter.BasePresenter;
import com.und.core.Layout.activity.uBaseActivity;
import butterknife.ButterKnife;

/**
 * Created by hungle on 01/03/2019.
 */

public abstract class uBaseFragment<P extends BasePresenter> extends Fragment implements IBaseFragment {

    public String TAG = "BaseFragment";

    public P mPresenter;
    private FrameLayout mFragmentContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializePresenter(getContext());

        View view = inflater.inflate(layout(), container, false);

        ButterKnife.bind(this, view);

        onCreateView();

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onViewCreated(view);

        if (mPresenter != null)
            mPresenter.start();

        onLoad();
    }

    public void onViewCreated(View view) {
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mPresenter != null)
            mPresenter.finalize();
    }

    protected abstract void initializePresenter(Context ctx);

    @Override
    public void showProgressDialog() {
        if (isAdded())
            if (getActivity() != null) {
                if (getActivity() instanceof uBaseActivity)
                    ((uBaseActivity) getActivity()).showProgressDialog();
            }
    }


    @Override
    public void hideProgressDialog() {
        if (isAdded())
            if (getActivity() != null) {
                if (getActivity() instanceof uBaseActivity)
                    ((uBaseActivity) getActivity()).hideProgressDialog();
            }
    }

    @Override
    public void openActivity(Class<? extends uBaseActivity> cls) {
        if (isAdded()) {
            if (getActivity() instanceof uBaseActivity)
                ((uBaseActivity) getActivity()).openActivity(cls);
        }
    }

    @Override
    public void openActivity(Class<? extends uBaseActivity> cls, Bundle bundle) {
        if (getActivity() instanceof uBaseActivity)
            ((uBaseActivity) getActivity()).openActivity(cls, bundle);
    }

    @Override
    public void openActivityForResult(Class cls, Bundle bundle, int req_code) {
        if (getActivity() instanceof uBaseActivity)
            ((uBaseActivity) getActivity()).openActivityForResult(cls, bundle, req_code);
    }

    @Override
    public void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls) {
        if (isAdded()) {
            if (getActivity() instanceof uBaseActivity)
                ((uBaseActivity) getActivity()).cleanAllActivityFromStack(cls);
        }
    }

    @Override
    public void finish() {
        getActivity().finish();
    }


    public void showLoadingView() {
        if (getActivity() instanceof uBaseActivity)
            ((uBaseActivity) getActivity()).showLoadingView();
    }


    public void hideLoadingView() {
        if (getActivity() instanceof uBaseActivity)
            ((uBaseActivity) getActivity()).hideLoadingView();
    }

    public void refresh() {}

}
