package com.etisalat.sampletask.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.BaseActivity;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.models.CachingDataHandler;
import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.presenters.MainActivityPresenter;
import com.etisalat.sampletask.utils.DateTimeHandler;

import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityListener {

    RecyclerView recyclerView;
    LinearLayout linearLayout;
    TextView tv_last_update;
    Button btn_refresh, btn_kotlin_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    protected BasePresenter setupPresenter() {
        return new MainActivityPresenter(this, this);
    }

    @Override
    public void onListRetrieved(List<Item> itemsList) {
        displayList(itemsList);
    }

    @Override
    public void onError(String error) {
        showSnackbar(error, linearLayout);
        hideProgress();
        tv_last_update.setVisibility(View.GONE);
    }

    /**
     * initializing the views
     */
    private void initViews(){
        showProgress();
        recyclerView = findViewById(R.id.lv_food_items);
        linearLayout = findViewById(R.id.linearLayout);
        tv_last_update = findViewById(R.id.tv_last_update);
        btn_refresh = findViewById(R.id.btn_refresh);
        btn_kotlin_activity = findViewById(R.id.btn_camera_activity);
        btn_kotlin_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CameraActivity.class));
            }
        });

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_last_update.setVisibility(View.GONE);
                applyRefreshAction();
            }
        });

        if(CachingDataHandler.loadObject() == null){
            ((MainActivityPresenter) getPresenter()).getFoodList();
        }else{
            displayList(CachingDataHandler.loadObject().getItems());
        }
        tv_last_update.setText(DateTimeHandler.getDate(CachingDataHandler.getDateTimeAsMillis(this)));
        getSupportActionBar().setTitle(DateTimeHandler.getDate(System.currentTimeMillis()));
    }

    /**
     * doing the refresh action to refresh list items
     */
    private void applyRefreshAction() {
        showProgress();
        ((MainActivityPresenter) getPresenter()).getFoodList();
        tv_last_update.setText(DateTimeHandler.getDate(System.currentTimeMillis()));
        getSupportActionBar().setTitle(DateTimeHandler.getDate(System.currentTimeMillis()));
    }

    /**
     * displaying list of items on the recycler view
     * @param itemsList
     */
    private void displayList(List<Item> itemsList){
        tv_last_update.setVisibility(View.VISIBLE);
        FoodItemsListAdapter adapter = new FoodItemsListAdapter(itemsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        hideProgress();
    }
}
