package com.zapme.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zapme.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jalmei14 on 3/28/17.
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.shortDescription)
    TextView shortDescription;

    @BindView(R.id.number)
    TextView number;

    @BindView(R.id.whole_view)
    View view;

    public ContactViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(TextView shortDescription) {
        this.shortDescription = shortDescription;
    }

    public TextView getNumber() {
        return number;
    }

    public void setNumber(TextView number) {
        this.number = number;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}


