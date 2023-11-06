package org.kenny.data_strucute.hashtablecustom;

import java.util.LinkedList;

public class HashTableGeneric<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        LinkedList<Entry> bucket = getOrCreateBucket(key);
        bucket.add(new Entry(key, value));

    }

    public V get(K key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(K key) {
        Entry entry = getEntry(key);
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        getBucket(key).remove(entry);
    }


    private LinkedList<Entry> getBucket(K key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(K key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            entries[index] = bucket;
        }
        return bucket;
    }

    private Entry getEntry(K key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    private int hash(K key) {
        return key.hashCode() % entries.length;
    }
}
