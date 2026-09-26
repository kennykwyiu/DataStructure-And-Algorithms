package org.kenny.designpattern.factory;

public interface AbstractFactory {
    Contact createContact(String value);
    Notification createNotification();
}
