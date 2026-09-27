package org.kenny.designpattern.factory.factories;

import org.kenny.designpattern.factory.products.contact.Contact;
import org.kenny.designpattern.factory.products.notification.Notification;
import org.kenny.designpattern.factory.products.contact.PhoneContact;
import org.kenny.designpattern.factory.products.notification.PhoneNotification;

public class PhoneFactory implements AbstractFactory {
    @Override
    public Contact createContact(String phoneNumber) {
        return new PhoneContact(phoneNumber);
    }

    @Override
    public Notification createNotification() {
        return new PhoneNotification();
    }
}
