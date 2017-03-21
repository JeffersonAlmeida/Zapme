package com.zapme.list.presenter;

import com.zapme.Service;
import com.zapme.list.view.ContactsListView;
import com.zapme.model.Contact;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ContactsListPresenter {

    private ContactsListView view;

    private Service service;

    @Inject
    public ContactsListPresenter(Service service) {
        this.service = service;
    }

    public void attachView(ContactsListView view){
        this.view = view;
    }

    public void loadContacts(){

        view.showLoadingSpinner();

        service.getContactstList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Contact>>() {
                    @Override
                    public void onCompleted() {
                        view.hideLoadingSpinner();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideLoadingSpinner();
                        view.showError();
                    }

                    @Override
                    public void onNext(List<Contact> contactList) {
                        if ( contactList.isEmpty() ){
                            view.showEmptyContactsList();
                        } else {
                            view.showContactsList(contactList);
                        }
                    }
                });

    }
}
