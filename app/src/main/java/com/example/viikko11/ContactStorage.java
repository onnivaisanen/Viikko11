package com.example.viikko11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ContactStorage {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage instance;

    private ContactStorage() {
        contacts = new ArrayList<>();
    }

    public static ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }

    }

    public void removeContactsStartingWithLetter(String letter) {
        Iterator<Contact> iterator = ContactStorage.getInstance().getContacts().iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().startsWith(letter)) {
                iterator.remove();
            }
        }
    }

    public void sortAlphabetically() {
        Collections.sort(contacts, (c1, c2) -> c1.getFullName().compareToIgnoreCase(c2.getFullName()));
    }

    public void sortByGroup() {
        contacts.sort(Comparator.comparing(Contact::getContactGroup, String::compareToIgnoreCase));
    }

}
