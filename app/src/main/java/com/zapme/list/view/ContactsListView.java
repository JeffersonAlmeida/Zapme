package com.zapme.list.view;

import com.zapme.model.Contact;

import java.util.List;

/**
 * Created by jalmei14 on 3/21/17.
 */

public interface ContactsListView {

    void showContactsList(List<Contact> contactList);
    void showEmptyContactsList();

    void showLoadingSpinner();
    void hideLoadingSpinner();

    void showError();

}
