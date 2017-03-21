package com.zapme.mocks;

import com.zapme.Service;
import com.zapme.model.Contact;
import com.zapme.util.FabricForTests;

import java.util.List;

import rx.Observable;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ServiceMock implements Service {

    @Override
    public Observable<List<Contact>> getContactstList() {
        return Observable
                .just(FabricForTests.getContactsListFromJson());
    }

}
