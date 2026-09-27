package org.kenny.designpattern.factory.factories;

import org.kenny.designpattern.factory.products.contact.Contact;
import org.kenny.designpattern.factory.products.notification.Notification;

public interface AbstractFactory {
    Contact createContact(String value);
    Notification createNotification();
}
