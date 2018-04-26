package com.etisalat.sampletask.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.BaseActivity;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.models.CachingDataHandler;
import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.presenters.MainActivityPresenter;

import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityListener {

    RecyclerView recyclerView;
    LinearLayout linearLayout;

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
    }

    private void initViews(){
        showProgress();
        recyclerView = findViewById(R.id.lv_food_items);
        linearLayout = findViewById(R.id.linearLayout);
        if(CachingDataHandler.loadObject() == null){
            ((MainActivityPresenter) getPresenter()).getFoodList();
        }else{
            displayList(CachingDataHandler.loadObject().getItems());
        }
    }

    private void displayList(List<Item> itemsList){
        FoodItemsListAdapter adapter = new FoodItemsListAdapter(itemsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        hideProgress();
    }
}
