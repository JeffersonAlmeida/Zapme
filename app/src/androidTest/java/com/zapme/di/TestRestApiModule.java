package com.zapme.di;

import com.zapme.Service;
import com.zapme.mocks.ServiceMock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jalmei14 on 3/21/17.
 */

@Module
public class TestRestApiModule {

    @Provides
    @Singleton
    Service providesService(){
        return new ServiceMock();
    }
}
