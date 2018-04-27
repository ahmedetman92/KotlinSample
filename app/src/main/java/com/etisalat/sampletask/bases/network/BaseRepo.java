package com.etisalat.sampletask.bases.network;

import android.app.Application;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public class BaseRepo<T> {

    /**
     * executing retrofit api calls
     * @param call
     * @param apiCallBack
     */
    protected void execute(Call<T> call, final ApiCallback apiCallBack) {
        if (!NetworkConnectionUtil.isNetworkAvailable()) {
            apiCallBack.error("network unavailable");
        } else {
            call.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    if (response.isSuccessful()) {
                        apiCallBack.success(response);
                    }
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    apiCallBack.error("failed");
                }
            });
        }
    }

}
