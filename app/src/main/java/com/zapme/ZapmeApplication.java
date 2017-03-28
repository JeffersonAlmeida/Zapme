package com.zapme;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.google.firebase.FirebaseApp;
import com.zapme.di.DaggerRestApiComponent;
import com.zapme.di.RestApiComponent;
import com.zapme.di.RestApiModule;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ZapmeApplication extends MultiDexApplication {

    private RestApiComponent restApiComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);

        restApiComponent = DaggerRestApiComponent
                .builder()
                .restApiModule(new RestApiModule())
                .build();

    }

    public RestApiComponent getRestApiComponent() {
        return restApiComponent;
    }

}
