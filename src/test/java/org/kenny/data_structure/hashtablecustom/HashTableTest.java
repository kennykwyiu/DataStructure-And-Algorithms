package org.kenny.data_structure.hashtablecustom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable();
    }

    @Test
    public void testPutAndGet() {
        hashTable.put(1, "value1");
        hashTable.put(2, "value2");
        hashTable.put(3, "value3");

        Assertions.assertEquals("value1", hashTable.get(1));
        Assertions.assertEquals("value2", hashTable.get(2));
        Assertions.assertEquals("value3", hashTable.get(3));
    }

    @Test
    public void testUpdateValue() {
        hashTable.put(1, "value1");
        hashTable.put(1, "updatedValue");

        Assertions.assertEquals("updatedValue", hashTable.get(1));
    }

    @Test
    public void testRemove() {
        hashTable.put(1, "value1");
        hashTable.put(2, "value2");

        hashTable.remove(1);

        Assertions.assertNull(hashTable.get(1));
        Assertions.assertEquals("value2", hashTable.get(2));
    }

    @Test
    public void testRemoveNonexistentKey() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hashTable.remove(999);
        });
    }
}
