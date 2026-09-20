package org.kenny.designpattern.factory;

public class SmsContact implements Contact {
    private final String phoneNumber;

    public SmsContact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        System.out.println("SMS Contact: " + phoneNumber);
    }
}
