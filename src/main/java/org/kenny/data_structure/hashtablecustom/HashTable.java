package org.kenny.data_structure.hashtablecustom;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

//        for (Entry entry : bucket) {
//            if (entry.key == key) {
//                entry.value = value;
//                return;
//            }
//        }
//        var entry = new Entry(key, value);

        LinkedList<Entry> bucket = getOrCreateBucket(key);
        bucket.add(new Entry(key, value));

    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;


//        int index = hash(key);
//        LinkedList<Entry> bucket = entries[index];
//        if (!isNull(bucket)) {
//            for (Entry entry : bucket) {
//                if (entry.key == key) {
//                    return entry.value;
//                }
//            }
//        }
//        return null;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        getBucket(key).remove(entry);

//        int index = hash(key);
//        LinkedList<Entry> bucket = entries[index];
//        if (Objects.isNull(bucket)) {
//            throw new IllegalStateException();
//        }
//
//        for (Entry entry : bucket) {
//            if (entry.key == key) {
//                bucket.remove(entry);
//                return;
//            }
//        }
//        throw new IllegalStateException();
    }


    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            entries[index] = bucket;
        }
        return bucket;
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
