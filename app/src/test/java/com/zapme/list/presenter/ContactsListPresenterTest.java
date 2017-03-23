package com.zapme.list.presenter;

import com.zapme.list.view.ContactsListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by jalmei14 on 3/22/17.
 */
public class ContactsListPresenterTest {

    ContactsListPresenter contactsListPresenter;

    ContactsListView contactsListView;

    @Before
    public void setUp() throws Exception {
        contactsListView = Mockito.mock(ContactsListView.class);
        contactsListPresenter = Mockito.mock(ContactsListPresenter.class);
        contactsListPresenter.attachView(contactsListView);
    }

    @Test
    public void loadContacts() throws Exception {

        Mockito.verify(contactsListPresenter).loadContacts();

        Mockito.verify(contactsListView).showLoadingSpinner();
        Mockito.verify(contactsListView, Mockito.times(1)).showLoadingSpinner();
        Mockito.verify(contactsListView).showContactsList(Mockito.anyList());

    }

}