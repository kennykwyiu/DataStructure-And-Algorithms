package org.kenny.designpattern.factory;

public class PhoneNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Making phone call with message: " + message);
    }
}