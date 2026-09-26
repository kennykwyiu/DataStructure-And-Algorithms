package org.kenny.designpattern.factory;

class EmailFactory implements AbstractFactory {
    @Override
    public Contact createContact(String email) {
        return new EmailContact(email);
    }

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
