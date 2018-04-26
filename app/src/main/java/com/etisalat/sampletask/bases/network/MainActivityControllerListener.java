package com.etisalat.sampletask.bases.network;

import com.etisalat.sampletask.bases.BaseControllerListener;
import com.etisalat.sampletask.models.Menu;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public interface MainActivityControllerListener extends BaseControllerListener {
    void onSuccess(Menu response);
    void onFail(String error);
}
