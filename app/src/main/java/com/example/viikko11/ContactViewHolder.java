package com.example.viikko11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    ImageView ContactDetailsButton;
    ImageView ContactDeleteButton;
    TextView ContactNameText, ContactNumberText, ContactGroupText;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        ContactNameText = itemView.findViewById(R.id.ContactNameText);
        ContactNumberText = itemView.findViewById(R.id.ContactNumberText);
        ContactGroupText = itemView.findViewById(R.id.ContactGroupText);
        ContactDetailsButton = itemView.findViewById(R.id.ContactDetailsButton);
        ContactDeleteButton = itemView.findViewById(R.id.ContactDeleteButton);

    }
}
