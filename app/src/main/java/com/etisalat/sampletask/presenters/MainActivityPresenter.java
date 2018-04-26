package com.etisalat.sampletask.presenters;

import com.etisalat.sampletask.bases.BasePresenter;
import com.etisalat.sampletask.bases.BasePresenterListener;
import com.etisalat.sampletask.bases.network.MainActivityControllerListener;
import com.etisalat.sampletask.bases.network.ServicesHandler;
import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.models.Menu;
import com.etisalat.sampletask.views.MainActivityListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Response;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public class MainActivityPresenter extends BasePresenter  {

    MainActivityListener mMainActivityListener;
    public MainActivityPresenter(BasePresenterListener listener, MainActivityListener mainActivityListener) {
        super(listener);
        mMainActivityListener = mainActivityListener;
    }


    public void getFoodList(){
        ServicesHandler servicesHandler = new ServicesHandler();
        servicesHandler.getAllFood(new MainActivityControllerListener() {
            @Override
            public void onSuccess(Menu response) {

                sortFoodList(response.getItems());
                mMainActivityListener.onListRetrieved(response.getItems());
            }

            @Override
            public void onFail(String error) {
                mMainActivityListener.onError(error);
            }
        });

    }


    public List<Item> sortFoodList(List<Item> list) {
        if (list.size() > 0) {
            Collections.sort(list, new Comparator<Item>() {
                @Override
                public int compare(final Item item1, final Item item2) {
                    return item1.getName().compareTo(item2.getName());
                }
            });
            return list;
        }else
            return null;
    }

}
