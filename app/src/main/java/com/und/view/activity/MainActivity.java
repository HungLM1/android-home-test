package com.und.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.und.core.Layout.activity.uBaseActivity;
import com.und.models.KeywordModel;
import com.und.adapter.CategoriseAdapter.CategoriseAdapter;
import com.und.R;
import com.und.models.CatagoriesModel;
import com.und.utils.manager.ottobus.OttoBusManager;
import com.und.utils.manager.ottobus.model.JobModel;
import com.und.utils.manager.scheduler.JobScheduler;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hungle on 01/03/2019.
 */

public class MainActivity extends uBaseActivity<MainPresenter> implements MainContract.View {

    private TextView mTextView;
    private ProgressBar mProgressBar;
    private CategoriseAdapter mAdapter;

    private ArrayList<CatagoriesModel> mKeywords;

    @Nullable
    @BindView(R.id.my_recycler_view)
    RecyclerView my_recycler_view;

    @Override
    protected void initializePresenter(uBaseActivity activity) {
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onCreateView() {

        mKeywords = new ArrayList<CatagoriesModel>();

        createDummyData();

        my_recycler_view.setHasFixedSize(true);

        mAdapter = new CategoriseAdapter(this, mKeywords);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(mAdapter);

        /* add notification bus */
        OttoBusManager.getInstance().register(this);
    }

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    /**
     * onReceiveNotification()
     * notify when to time for change display
     *
     * @param Notification
     * The information of need to me change display
     *
     * @return none
     */
    @Subscribe
    public void onReceiveNotification(JobModel Notification) {

        mPresenter.onChangeKeywordPosition(mAdapter.getAdapterItemCount(0), 0);
    }

    @Override
    public void onChangeKeywordPosition(int pos) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mAdapter.smoothScrollToPosition(pos);
            }
        });
    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        /* start scheduler service */
        startService(new Intent(this, JobScheduler.class));
    }

    @Override
    protected void onStop() {
        super.onStop();

        /* stop scheduler service */
        startService(new Intent(this, JobScheduler.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

         /* add notification bus */
        OttoBusManager.getInstance().unRegister(this);
    }


    /* this code for temporary will be change */
    public void createDummyData() {

        for (int i = 1; i <= 1; i++) {

            CatagoriesModel dm = new CatagoriesModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<KeywordModel> singleItem = new ArrayList<KeywordModel>();
            for (int j = 0; j <= 20; j++) {
                singleItem.add(new KeywordModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            mKeywords.add(dm);
        }
    }
}
