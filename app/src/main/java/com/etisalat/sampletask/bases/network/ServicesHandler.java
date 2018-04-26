package com.etisalat.sampletask.bases.network;

import android.util.Log;

import com.etisalat.sampletask.models.Menu;

import retrofit2.Response;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public class ServicesHandler extends BaseRepo {

    public void getAllFood(final MainActivityControllerListener mainActivityControllerListener){
        execute(ApiConnection.retrofitForXML(ApiServices.BASE_URL).create(ApiServices.class).getFood(),
                new ApiCallback() {
                    @Override
                    public void success(Object response) {
                        Menu menu = (Menu) ((Response) response).body();
                        mainActivityControllerListener.onSuccess(menu);
                        Log.e("ServicesHandler",response.toString());
                    }

                    @Override
                    public void error(String errorMessage) {
                        mainActivityControllerListener.onFail(errorMessage);
                        Log.e("ServicesHandler", errorMessage);
                    }
                });
    }
}
