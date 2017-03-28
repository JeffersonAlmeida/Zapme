package com.zapme;

import com.zapme.model.Contact;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.PUT;
import rx.Observable;

/**
 * Created by jalmei14 on 3/21/17.
 */

public interface Service {

    @GET("/")
    Observable<List<Contact>> getContactstList();

    @PUT("save")
    Observable<Contact> saveContact(Contact contact);

}
