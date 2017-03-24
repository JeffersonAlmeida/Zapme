package com.zapme.create.presenter;

import com.zapme.RxSchedulersOverrideRule;
import com.zapme.Service;
import com.zapme.create.view.CreateContactView;
import com.zapme.model.Contact;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by jalmei14 on 3/24/17.
 */
public class CreateContactPresenterTest {

    CreateContactPresenter createContactPresenter;

    @Mock
    CreateContactView createContactView;

    @Mock
    Service service;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


        this.createContactPresenter = new CreateContactPresenter(service);
        this.createContactPresenter.attachView(createContactView);
    }

    @Test
    public void saveContact() throws Exception {

        // Given
        Mockito.when(service.saveContact(Mockito.any(Contact.class)))
                .thenReturn(Observable.just(new Contact()));

        // Do
        this.createContactPresenter.saveContact(new Contact());

        // Check
        verify(createContactView).showLoadingSpinner();
        verify(createContactView).hideLoadingSpinner();
        verify(createContactView).onCreateContactSuccessfully();

        verify(createContactView, never()).onCreateContactError();


    }

}