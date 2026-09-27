package org.kenny.designpattern.factory.products.contact;

public class PhoneContact implements Contact {
    private final String phoneNumber;

    public PhoneContact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        System.out.println("Phone Contact: " + phoneNumber);
    }
}