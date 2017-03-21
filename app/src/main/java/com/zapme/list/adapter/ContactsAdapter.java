package com.zapme.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zapme.R;
import com.zapme.model.Contact;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    private List<Contact> list;

    @Inject
    public ContactsAdapter() {
        this.list = new ArrayList<>();
    }

    public void setList(List<Contact> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View screen = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);

        return new ContactsViewHolder(screen);
    }

    @Override
    public int getItemCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

        Contact contact = list.get(position);
        String description = contact.getShortDescription();
        holder.shortDescription.setText(description);

    }

    static class ContactsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.shortDescription)
        TextView shortDescription;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
