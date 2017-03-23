package com.zapme.create.view;

/**
 * Created by jalmei14 on 3/24/17.
 */

public interface CreateContactView {

    void showLoadingSpinner();
    void hideLoadingSpinner();

    void onCreateContactSuccessfully();
    void onCreateContactError();
}
