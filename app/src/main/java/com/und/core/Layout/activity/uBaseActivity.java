package com.und.core.Layout.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.und.R;
import com.und.core.Interface.IBaseActivity;
import com.und.core.Presenter.BasePresenter;

/**
 * Created by hungle on 01/03/2019.
 */

public abstract class uBaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseActivity {

    protected P mPresenter;

    ProgressDialog mProgressBar;

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Nullable
    @BindView(R.id.layout_loading_view)
    View loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout());

        ButterKnife.bind(this);

        setupBaseView();

        initializePresenter(this);

        onCreateView();

        if (mPresenter != null)
            mPresenter.start();

        onLoad();
    }

    protected void setupToolbar() {
        if (mToolbar != null)
            setSupportActionBar(mToolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mPresenter != null)
            mPresenter.finalize();
    }


    @Override
    public void showProgressDialog() {
        if (mProgressBar == null) {
            mProgressBar = new ProgressDialog(this);
            mProgressBar.setCancelable(false);
            mProgressBar.setMessage("Đang xử lý ...");
            mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressBar.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressBar != null) {
            mProgressBar.dismiss();
            mProgressBar = null;
        }
    }

    @Override
    public void openActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public void openActivity(Class cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void openActivityForResult(Class cls, Bundle bundle, int req_code) {
        Intent intent = new Intent(this, cls);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivityForResult(intent, req_code);
    }

    @Override
    public void finish() {
        super.finish();
    }

    private void setupBaseView() {
        setupToolbar();
    }

    protected abstract void initializePresenter(uBaseActivity activity);

    public void showError(String message) {

    }

    public void showMessage(String message) {

    }

    public void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        finish();
    }

    public void cleanAllActivityFromStack(Class<? extends uBaseActivity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);

        finish();
    }


}

