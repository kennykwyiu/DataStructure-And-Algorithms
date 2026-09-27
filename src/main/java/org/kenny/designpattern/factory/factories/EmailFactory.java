package org.kenny.designpattern.factory.factories;

import org.kenny.designpattern.factory.products.contact.Contact;
import org.kenny.designpattern.factory.products.contact.EmailContact;
import org.kenny.designpattern.factory.products.notification.EmailNotification;
import org.kenny.designpattern.factory.products.notification.Notification;

public class EmailFactory implements AbstractFactory {
    @Override
    public Contact createContact(String email) {
        return new EmailContact(email);
    }

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
