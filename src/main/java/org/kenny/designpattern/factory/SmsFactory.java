package org.kenny.designpattern.factory;

public class SmsFactory implements AbstractFactory {
    @Override
    public Contact createContact(String phoneNumber) {
        return new SmsContact(phoneNumber);
    }

    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
