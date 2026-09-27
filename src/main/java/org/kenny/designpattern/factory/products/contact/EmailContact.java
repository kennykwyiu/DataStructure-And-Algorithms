package org.kenny.designpattern.factory.products.contact;

public class EmailContact implements Contact {
    private final String email;

    public EmailContact(String email) {
        this.email = email;
    }

    @Override
    public void display() {
        System.out.println("Email Contact: " + email);
    }
}