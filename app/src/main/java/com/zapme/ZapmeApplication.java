package com.zapme;

import android.app.Application;

import com.zapme.di.DaggerRestApiComponent;
import com.zapme.di.RestApiComponent;
import com.zapme.di.RestApiModule;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ZapmeApplication extends Application {

    private RestApiComponent restApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        restApiComponent = DaggerRestApiComponent
                .builder()
                .restApiModule(new RestApiModule())
                .build();

    }

    public RestApiComponent getRestApiComponent() {
        return restApiComponent;
    }

}
