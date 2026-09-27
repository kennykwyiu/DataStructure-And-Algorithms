package org.kenny.threadlocal;

import lombok.extern.log4j.Log4j2;

/**
 * Consumer Component retrieving context values from ThreadLocal.
 */
@Log4j2
public class BeanFive {
    public void invoke() {
        String value = ContextCache.getAttribute("key1");
        System.out.println("get key1, value is " + value);
    }
}
