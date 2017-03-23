package com.zapme;

import com.zapme.di.DaggerTestRestApiComponent;
import com.zapme.di.RestApiComponent;
import com.zapme.di.TestRestApiComponent;
import com.zapme.di.TestRestApiModule;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class MockZapMeApplication extends ZapmeApplication {

    private TestRestApiComponent testRestApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        testRestApiComponent = DaggerTestRestApiComponent
                .builder()
                .testRestApiModule(new TestRestApiModule())
                .build();
    }

    @Override
    public RestApiComponent getRestApiComponent() {
        return testRestApiComponent;
    }
}
