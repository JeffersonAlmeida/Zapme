package com.zapme.di;

import com.zapme.create.view.CreateContactActivityTest;
import com.zapme.list.view.ContactsListActivityTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jalmei14 on 3/21/17.
 */

@Singleton
@Component ( modules = TestRestApiModule.class )
public interface TestRestApiComponent extends RestApiComponent {

    void inject (ContactsListActivityTest contactsListActivityTest);

    void inject(CreateContactActivityTest createContactActivityTest);

}
