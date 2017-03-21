package com.zapme.list.view;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zapme.Service;
import com.zapme.ZapmeApplication;
import com.zapme.di.TestRestApiComponent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.inject.Inject;

/**
 * Created by jalmei14 on 3/21/17.
 */
@RunWith(AndroidJUnit4.class)
public class ContactsListActivityTest {

    @Inject
    Service service;

    @Rule
    public ActivityTestRule<ContactsListActivity> contactsListActivity =
            new ActivityTestRule<>(ContactsListActivity.class, true, false);

    @Before
    public void setUp() throws Exception {

        ZapmeApplication application = (ZapmeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();

        TestRestApiComponent restApiComponent =
                (TestRestApiComponent) application.getRestApiComponent();

        restApiComponent.inject(this);


    }

    @Test
    public void showContactsList() throws Exception {
        contactsListActivity.launchActivity(new Intent());
        Thread.sleep(3000);

        Mockito.verify(service).getContactstList();
        Mockito.verify(service).
    }

//    @Test
//    public void showEmptyContactsList() throws Exception {
//
//    }
//
//    @Test
//    public void showLoadingSpinner() throws Exception {
//
//    }
//
//    @Test
//    public void hideLoadingSpinner() throws Exception {
//
//    }
//
//    @Test
//    public void showError() throws Exception {
//
//    }

}