package com.etisalat.sampletask.bases.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.etisalat.sampletask.bases.ApplicationContextProvider;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public class NetworkConnectionUtil {

    /**
     * checking if the network is available
     * @return
     */
    public static boolean isNetworkAvailable() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) ApplicationContextProvider.getContext().
                        getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
