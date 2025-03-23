package com.example.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<Contact> contacts;

    public ContactListAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_view, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.ContactNameText.setText(contacts.get(position).getFullName());
        holder.ContactNumberText.setText(contacts.get(position).getNumber());
        holder.ContactGroupText.setText(contacts.get(position).getContactGroup());

        holder.ContactDetailsButton.setOnClickListener(v -> {

            if(holder.ContactNumberText.getVisibility() == View.VISIBLE) {
                holder.ContactGroupText.setVisibility(View.GONE);
                holder.ContactNumberText.setVisibility(View.GONE);

            } else {
            holder.ContactNumberText.setVisibility(View.VISIBLE);
            holder.ContactGroupText.setVisibility(View.VISIBLE);
            }

        });

        holder.ContactDeleteButton.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(pos);
            notifyItemRemoved(pos);
        });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
