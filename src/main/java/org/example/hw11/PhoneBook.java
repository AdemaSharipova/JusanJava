package org.example.hw11;

import java.util.*;

public class PhoneBook {
    private Map<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName,String phoneNumber) {
        HashSet<String> phones = phoneBook.get(lastName);
        if (phones == null) {
            phones = new HashSet<>();
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
        } else {
            phones.add(phoneNumber);
        }
    }

    public HashSet<String> get(String lastName) {
        HashSet<String> phones = phoneBook.get(lastName);
        if (phones == null) {
            phones = new HashSet<>();
        }
        return phones;
    }

}
