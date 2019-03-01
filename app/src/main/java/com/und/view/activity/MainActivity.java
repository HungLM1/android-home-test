package com.und.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.und.core.Layout.activity.uBaseActivity;
import com.und.models.KeyworkModel;
import com.und.adapter.CategoriseAdapter.CategoriseAdapter;
import com.und.R;
import com.und.models.CatagoriesModel;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hungle on 01/03/2019.
 */

public class MainActivity extends uBaseActivity<MainPresenter> implements MainContract.View {

    private TextView textView;
    private ProgressBar progressBar;

    ArrayList<CatagoriesModel> allSampleData;

    @Nullable
    @BindView(R.id.my_recycler_view)
    RecyclerView my_recycler_view;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void initializePresenter(uBaseActivity activity) {
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    public void createDummyData() {

        for (int i = 1; i <= 1; i++) {

            CatagoriesModel dm = new CatagoriesModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<KeyworkModel> singleItem = new ArrayList<KeyworkModel>();
            for (int j = 0; j <= 20; j++) {
                singleItem.add(new KeyworkModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onCreateView() {

        allSampleData = new ArrayList<CatagoriesModel>();

        createDummyData();

        my_recycler_view.setHasFixedSize(true);

        CategoriseAdapter adapter = new CategoriseAdapter(this, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);
    }

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showLoadingView() {

    }
}
