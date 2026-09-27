package org.kenny.designpattern.factory.factories;

import org.kenny.designpattern.factory.products.contact.Contact;
import org.kenny.designpattern.factory.products.notification.Notification;
import org.kenny.designpattern.factory.products.contact.SmsContact;
import org.kenny.designpattern.factory.products.notification.SmsNotification;

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
