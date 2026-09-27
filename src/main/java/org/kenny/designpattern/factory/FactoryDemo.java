package org.kenny.designpattern.factory;

import org.kenny.designpattern.factory.factories.AbstractFactory;
import org.kenny.designpattern.factory.factories.EmailFactory;
import org.kenny.designpattern.factory.factories.PhoneFactory;
import org.kenny.designpattern.factory.factories.SmsFactory;
import org.kenny.designpattern.factory.products.contact.Contact;
import org.kenny.designpattern.factory.products.notification.Notification;

public class FactoryDemo {
    enum FactoryType {EMAIL, PHONE, SMS}

    public static void main(String[] args) {
        // In a real application this could come from a config file or environment variable
        FactoryType type = FactoryType.SMS;
        AbstractFactory factory = getFactory(type);

        Contact contact = factory.createContact("+1234567890");
        Notification notification = factory.createNotification();

        contact.display();
        notification.send("Hello from the factory demo!");
    }

    private static AbstractFactory getFactory(FactoryType type) {
        return switch (type) {
            case EMAIL -> new EmailFactory();
            case PHONE -> new PhoneFactory();
            case SMS -> new SmsFactory();
        };
    }
}
