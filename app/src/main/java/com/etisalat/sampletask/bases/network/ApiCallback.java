package com.etisalat.sampletask.bases.network;

/**
 * Created by Ahmed Etman on 4/25/2018.
 */

public interface ApiCallback<T> {
        void success(T response);
        void error(String errorMessage);
}
