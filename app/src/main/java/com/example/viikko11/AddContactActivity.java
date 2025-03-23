package com.example.viikko11;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {
    private EditText FirstNameEdit, LastNameEdit, PhoneNumberEdit;
    private RadioGroup ContactTypeRadioGroup;
    private Button AddContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstraintLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        LastNameEdit = findViewById(R.id.LastNameEdit);
        PhoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        ContactTypeRadioGroup = findViewById(R.id.ContactTypeRadioGroup);
        AddContactButton = findViewById(R.id.AddContactButton);

        AddContactButton.setOnClickListener(v -> {
        String firstName = FirstNameEdit.getText().toString();
        String lastName = LastNameEdit.getText().toString();
        String phoneNumber = PhoneNumberEdit.getText().toString();
        String contactGroup = ((RadioButton) findViewById(ContactTypeRadioGroup.getCheckedRadioButtonId())).getText().toString();

        Contact newContact = new Contact(firstName, lastName, phoneNumber, contactGroup);
        ContactStorage.getInstance().addContact(newContact);
        finish();
        });
    }
}

