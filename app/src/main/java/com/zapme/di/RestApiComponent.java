package com.zapme.di;

import com.zapme.list.view.ContactsListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jalmei14 on 3/21/17.
 */

@Singleton
@Component ( modules = RestApiModule.class )
public interface RestApiComponent {

    void inject(ContactsListActivity contactsListActivity);

}
