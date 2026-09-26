package org.kenny.designpattern.factory;

class PhoneFactory implements AbstractFactory {
    @Override
    public Contact createContact(String phoneNumber) {
        return new PhoneContact(phoneNumber);
    }

    @Override
    public Notification createNotification() {
        return new PhoneNotification();
    }
}
