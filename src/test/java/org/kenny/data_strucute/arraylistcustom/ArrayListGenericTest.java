package org.kenny.data_strucute.arraylistcustom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListGenericTest {
    private ArrayListGeneric<Integer> arrayList;

    @BeforeEach
    public void setUp() {
        arrayList = new ArrayListGeneric<>(5);
    }

    @Test
    public void testInsertAndGet() {
        arrayList.insert(10);
        arrayList.insert(20);
        arrayList.insert(30);

        Assertions.assertEquals(10, arrayList.get(0));
        Assertions.assertEquals(20, arrayList.get(1));
        Assertions.assertEquals(30, arrayList.get(2));
    }

    @Test
    public void testRemoveAt() {
        arrayList.insert(10);
        arrayList.insert(20);
        arrayList.insert(30);

        arrayList.removeAt(1);

        Assertions.assertEquals(10, arrayList.get(0));
        Assertions.assertEquals(30, arrayList.get(1));
        Assertions.assertEquals(-1, arrayList.indexOf(20));
    }

    @Test
    public void testIndexOf() {
        arrayList.insert(10);
        arrayList.insert(20);
        arrayList.insert(30);

        Assertions.assertEquals(0, arrayList.indexOf(10));
        Assertions.assertEquals(1, arrayList.indexOf(20));
        Assertions.assertEquals(2, arrayList.indexOf(30));
        Assertions.assertEquals(-1, arrayList.indexOf(40));
    }
}