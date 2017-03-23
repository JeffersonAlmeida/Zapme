package com.zapme.create.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zapme.R;
import com.zapme.ZapmeApplication;
import com.zapme.create.presenter.CreateContactPresenter;
import com.zapme.model.Contact;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateContactActivity extends AppCompatActivity implements CreateContactView {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.fab_create_contact)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.phone_number)
    EditText phone;

    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.description)
    EditText description;

    @Inject
    CreateContactPresenter createContactPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, CreateContactActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        ButterKnife.bind(this);

        ZapmeApplication application = (ZapmeApplication) getApplication();
        application.getRestApiComponent().inject(this);

        createContactPresenter.attachView(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createContactPresenter.saveContact(createContactFromView());
            }
        });
    }

    private Contact createContactFromView() {
        String phone = this.phone.getText().toString();
        String name = this.name.getText().toString();
        String description = this.description.getText().toString();
        return new Contact(phone, name, description);
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
    public void onCreateContactSuccessfully() {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void onCreateContactError() {
        Toast.makeText(this, "Sorry! We had a problem :(", Toast.LENGTH_SHORT).show();
    }
}
