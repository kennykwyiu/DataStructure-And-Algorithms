package org.kenny.threadlocal;

import lombok.extern.log4j.Log4j2;
/**
 * Producer Component setting context values into ThreadLocal.
 */
@Log4j2
public class BeanThree {
    public void invoke() {
        ContextCache.putAttribute("key1", "value1");
        System.out.println("put key1, value1 to contextCache success");
    }
}

