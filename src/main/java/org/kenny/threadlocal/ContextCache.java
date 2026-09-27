package org.kenny.threadlocal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Context Cache using InheritableThreadLocal to manage thread-local key-value pairs.
 */
public class ContextCache implements Serializable {
    private static final long serialVersionUID = 2136539028591849277L;

    public static final ThreadLocal<Map<String, String>> CACHE = new InheritableThreadLocal<>();

    public static final void putAttribute(String sourceKey, String value) {
        Map<String, String> cacheMap = CACHE.get();
        if (null == cacheMap) {
            cacheMap = new HashMap<>();
        }
        cacheMap.put(sourceKey, value);
        CACHE.set(cacheMap);
    }

    public static final String getAttribute(String sourceKey) {
        Map<String, String> cacheMap = CACHE.get();
        if (null == cacheMap) {
            return null;
        }
        return cacheMap.get(sourceKey);
    }

    public static final Map<String, String> getMap() {
        return CACHE.get();
    }

    public static final void putAllAttribute(Map<String, String> map) {
        Map<String, String> cacheMap = CACHE.get();
        if (null == cacheMap) {
            cacheMap = new HashMap<>();
        }
        if (map != null) {
            cacheMap.putAll(map);
        }
        CACHE.set(cacheMap);
    }

    public static final void clean() {
        CACHE.remove();
    }
}
