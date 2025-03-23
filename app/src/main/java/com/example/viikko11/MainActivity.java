package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private ContactStorage contactStorage;
    private RecyclerView recyclerView;
    private ContactListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button AddContactButton = findViewById(R.id.AddContactButton);
        Button SortAlphabeticallyButton = findViewById(R.id.SortAlphabeticallyButton);
        Button SortByGroupButton = findViewById(R.id.SortByGroupButton);
        recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactListAdapter(ContactStorage.getInstance().getContacts());
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstraintLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SortAlphabeticallyButton.setOnClickListener(v -> {
            ContactStorage.getInstance().sortAlphabetically();
            adapter.notifyDataSetChanged();
        });

        SortByGroupButton.setOnClickListener(v -> {
            ContactStorage.getInstance().sortByGroup();
            adapter.notifyDataSetChanged();
        });
    }

    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
    public void switchToAddContact(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }
}