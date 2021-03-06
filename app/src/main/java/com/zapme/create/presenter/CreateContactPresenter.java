package com.zapme.create.presenter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zapme.Service;
import com.zapme.create.view.CreateContactView;
import com.zapme.model.Contact;

import javax.inject.Inject;

/**
 * Created by jalmei14 on 3/24/17.
 */

public class CreateContactPresenter {

    private CreateContactView createContactView;

    private Service service;

    @Inject
    public CreateContactPresenter(Service service) {
        this.service = service;
    }

    public void attachView(CreateContactView createContactView){
        this.createContactView = createContactView;
    }

    public void saveContact(Contact contact){

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("contacts");
        reference.push().setValue(contact);

        createContactView.onCreateContactSuccessfully();

//        service.saveContact(contact)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Contact>() {
//                    @Override
//                    public void onCompleted() {
//                        createContactView.hideLoadingSpinner();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        createContactView.hideLoadingSpinner();
//                        createContactView.onCreateContactError();
//                    }
//
//                    @Override
//                    public void onNext(Contact contact) {
//                            createContactView.onCreateContactSuccessfully();
//                    }
//                });
    }
}
