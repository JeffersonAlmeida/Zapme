package com.zapme;

import com.zapme.model.Contact;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by jalmei14 on 3/22/17.
 */
public class ServiceTest {

    private static final String firstName = "Jefferson";
    private static final String secondName = "Teste";
    private static final String thirdName = "Maria";

    Service service;

    private List<Contact> contactList;

    @Before
    public void setUp() throws Exception {

        service = Mockito.mock(Service.class);

        contactList = new ArrayList<>();
        contactList.add(new Contact(firstName));
        contactList.add(new Contact(secondName));
        contactList.add(new Contact(thirdName));
    }

    @Test
    public void getContactstList() throws Exception {

        Mockito.when(service.getContactstList()).thenReturn(Observable.just(contactList));

        TestSubscriber<List<Contact>> testSubscriber = TestSubscriber.create();
        service.getContactstList().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();

        List<List<Contact>> onNextEvents = testSubscriber.getOnNextEvents();
        List<Contact> contactList = onNextEvents.get(0);

        Assert.assertEquals(contactList.get(0).getName(), firstName);
        Assert.assertEquals(contactList.get(1).getName(), secondName);
        Assert.assertEquals(contactList.get(2).getName(), thirdName);

    }



}