package com.zapme.list.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zapme.R;
import com.zapme.ZapmeApplication;
import com.zapme.list.adapter.ContactsAdapter;
import com.zapme.list.presenter.ContactsListPresenter;
import com.zapme.model.Contact;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsListActivity
        extends AppCompatActivity implements ContactsListView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    ContactsListPresenter contactsListPresenter;

    @Inject
    ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        ZapmeApplication application = (ZapmeApplication) getApplication();
        application.getRestApiComponent().inject(this);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ContactsAdapter();
        mRecyclerView.setAdapter(mAdapter);

        contactsListPresenter.attachView(this);
        contactsListPresenter.loadContacts();

    }

    @Override
    public void showContactsList(List<Contact> contactList) {
        mAdapter.setList(contactList);
    }

    @Override
    public void showEmptyContactsList() {
        Toast.makeText(this, "EMPTY", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingSpinner() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingSpinner() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

}
