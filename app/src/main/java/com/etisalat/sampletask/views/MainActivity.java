package com.etisalat.sampletask.views;

import android.os.Bundle;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.BaseActivity;
import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.models.Menu;
import com.etisalat.sampletask.presenters.MainActivityPresenter;

import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MainActivityPresenter)getPresenter()).getFoodList();
    }

    @Override
    protected BasePresenter setupPresenter() {
        return new MainActivityPresenter(this,this);
    }

    @Override
    public void onListRetrieved(List<Item> itemsList) {
       // List<Item> itemList = menu.getItems();
    }

    @Override
    public void onError(String error) {
        showSnackbar(error,null);
    }
}
