package com.zapme.list.presenter;

import com.zapme.FabricForTests;
import com.zapme.RxSchedulersOverrideRule;
import com.zapme.Service;
import com.zapme.list.view.ContactsListView;
import com.zapme.model.Contact;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import rx.Observable;

/**
 * Created by jalmei14 on 3/22/17.
 */
public class ContactsListPresenterTest {

    ContactsListPresenter contactsListPresenter;

    ContactsListView contactsListView;

    Service service;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() throws Exception {

        contactsListView = Mockito.mock(ContactsListView.class);
        service = Mockito.mock(Service.class);
        contactsListPresenter = new ContactsListPresenter(service);
        contactsListPresenter.attachView(contactsListView);
    }

    @Test
    public void loadContacts() throws Exception {

        // Given
        List<Contact> contactList = FabricForTests.getContactsListFromJson();
        Mockito.when(service.getContactstList()).thenReturn(Observable.just(contactList));

        // Do
        contactsListPresenter.loadContacts();

        // Check
        Mockito.verify(contactsListView).showLoadingSpinner();
        Mockito.verify(contactsListView, Mockito.times(1)).showLoadingSpinner();
        Mockito.verify(contactsListView).showContactsList(Mockito.anyList());

        Mockito.verify(contactsListView, Mockito.never()).showEmptyContactsList();
        Mockito.verify(contactsListView, Mockito.never()).showError();

    }

}