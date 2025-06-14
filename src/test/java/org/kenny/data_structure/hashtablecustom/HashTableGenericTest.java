package org.kenny.data_structure.hashtablecustom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableGenericTest {
    private HashTableGeneric<String, Integer> hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTableGeneric<>();
    }

    @Test
    public void testPutAndGet() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        hashTable.put("key3", 300);

        Assertions.assertEquals(100, hashTable.get("key1"));
        Assertions.assertEquals(200, hashTable.get("key2"));
        Assertions.assertEquals(300, hashTable.get("key3"));
    }

    @Test
    public void testUpdateValue() {
        hashTable.put("key1", 100);
        hashTable.put("key1", 200);

        Assertions.assertEquals(200, hashTable.get("key1"));
    }

    @Test
    public void testRemove() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);

        hashTable.remove("key1");

        Assertions.assertNull(hashTable.get("key1"));
        Assertions.assertEquals(200, hashTable.get("key2"));
    }

    @Test
    public void testRemoveNonexistentKey() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            hashTable.remove("nonexistentKey");
        });
    }
}
