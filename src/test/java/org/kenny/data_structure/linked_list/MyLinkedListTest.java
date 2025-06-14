package org.kenny.data_structure.linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyLinkedListTest {
    private MyLinkedList myLinkedList;

    @BeforeEach
    public void setup() {
        myLinkedList = new MyLinkedList();
    }

    @Test
    public void testAddAndGet() {
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);
        myLinkedList.add(3, 7);

        assertEquals(1, myLinkedList.get(0));
        assertEquals(3, myLinkedList.get(1));
        assertEquals(5, myLinkedList.get(2));
        assertEquals(7, myLinkedList.get(3));
    }

    @Test
    public void testSet() {
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);

        myLinkedList.set(1, 10);
        assertEquals(1, myLinkedList.get(0));
        assertEquals(10, myLinkedList.get(1));
    }

    @Test
    public void testRemove() {
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);

        int removedValue = myLinkedList.remove(1);
        assertEquals(3, removedValue);
        assertEquals(1, myLinkedList.get(0));
        assertEquals(5, myLinkedList.get(1));
    }

    @Test
    public void testTraverse() {
        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);
        myLinkedList.add(3, 7);
        myLinkedList.add(4, 9);

        // Redirect System.out to a stream for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        myLinkedList.travers();

        assertEquals("1 3 5 7 9", outputStream.toString().trim());
    }
}
