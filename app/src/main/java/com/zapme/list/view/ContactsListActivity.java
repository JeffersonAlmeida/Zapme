package com.zapme.list.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zapme.R;
import com.zapme.ZapmeApplication;
import com.zapme.create.view.CreateContactActivity;
import com.zapme.list.presenter.ContactsListPresenter;
import com.zapme.list.viewholder.ContactViewHolder;
import com.zapme.model.Contact;
import com.zapme.util.RecyclerItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.zapme.util.RecyclerItemClickListener.OnItemClickListener;

public class ContactsListActivity
        extends AppCompatActivity implements ContactsListView {

    private static final String CONTACTS = "contacts";

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    FloatingActionButton floatingActionButton;

    @Inject
    ContactsListPresenter contactsListPresenter;

    FirebaseRecyclerAdapter<Contact, ContactViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ZapmeApplication application = (ZapmeApplication) getApplication();
        application.getRestApiComponent().inject(this);

        ButterKnife.bind(this);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        DatabaseReference reference = firebaseDatabase.getReference(CONTACTS);

        adapter =
                new FirebaseRecyclerAdapter<Contact, ContactViewHolder>(Contact.class,
                        R.layout.activity_list_item, ContactViewHolder.class, reference) {

                    @Override
                    protected void populateViewHolder(final ContactViewHolder holder,
                                                      Contact contact, int position) {

                        String description = contact.getShortDescription();
                        holder.getShortDescription().setText(description);

                        String imageUrl = contact.getImageUrl();

                        Glide
                                .with(ContactsListActivity.this)
                                .load(imageUrl)
                                .centerCrop()
                                .bitmapTransform(new CropCircleTransformation(ContactsListActivity.this))
                                .crossFade()
                                .into(holder.getImageView());

                        final String name = contact.getName();
                        holder.getTitle().setText(name);

                        final String number = contact.getNumber();
                        holder.getNumber().setText(number);

                        progressBar.setVisibility(View.GONE);

                        holder.getView().setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                openWhatsApp(number);
                            }
                        });
                    }
                };

        progressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateContactActivity.start(ContactsListActivity.this);
            }
        });

    }

    private void openWhatsApp(String number) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }

    @Override
    public void showContactsList(List<Contact> contactList) {
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
