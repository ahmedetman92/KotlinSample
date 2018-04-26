package com.etisalat.sampletask.views;

import com.etisalat.sampletask.models.Item;
import com.etisalat.sampletask.models.Menu;

import java.util.List;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public interface MainActivityListener {
    void onListRetrieved(List<Item> list);
    void onError(String error);
}
