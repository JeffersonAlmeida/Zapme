package com.zapme.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zapme.R;
import com.zapme.model.Contact;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    private Context context;

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
        context = parent.getContext();
        View item = LayoutInflater.from(context)
                .inflate(R.layout.activity_list_item, parent, false);

        return new ContactsViewHolder(item);
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

        String imageUrl = contact.getImageUrl();

        Glide
                .with(context)
                .load(imageUrl)
                .centerCrop()
                .bitmapTransform(new CropCircleTransformation(context))
                .crossFade()
                .into(holder.imageView);

        String name = contact.getName();
        holder.title.setText(name);

        String number = contact.getNumber();
        holder.number.setText(number);

    }

    public List<Contact> getList() {
        return list;
    }

    static class ContactsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView imageView;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.shortDescription)
        TextView shortDescription;

        @BindView(R.id.number)
        TextView number;

        public ContactsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
