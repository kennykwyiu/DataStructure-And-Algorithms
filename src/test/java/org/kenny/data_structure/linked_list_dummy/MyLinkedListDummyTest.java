package org.kenny.data_structure.linked_list_dummy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListDummyTest {
    private MyLinkedListDummy myLinkedListDummy;

    @BeforeEach
    public void setup() {
        myLinkedListDummy = new MyLinkedListDummy();
    }

    @Test
    public void testAddAndGet() {
        myLinkedListDummy.add(0, 1);
        myLinkedListDummy.add(1, 3);
        myLinkedListDummy.add(2, 5);
        myLinkedListDummy.add(3, 7);

        assertEquals(1, myLinkedListDummy.get(0));
        assertEquals(3, myLinkedListDummy.get(1));
        assertEquals(5, myLinkedListDummy.get(2));
        assertEquals(7, myLinkedListDummy.get(3));
    }

    @Test
    public void testSet() {
        myLinkedListDummy.add(0, 1);
        myLinkedListDummy.add(1, 3);
        myLinkedListDummy.add(2, 5);

        myLinkedListDummy.set(1, 10);
        assertEquals(1, myLinkedListDummy.get(0));
        assertEquals(10, myLinkedListDummy.get(1));
    }

    @Test
    public void testRemove() {
        myLinkedListDummy.add(0, 1);
        myLinkedListDummy.add(1, 3);
        myLinkedListDummy.add(2, 5);

        int removedValue = myLinkedListDummy.remove(1);
        assertEquals(3, removedValue);
        assertEquals(1, myLinkedListDummy.get(0));
        assertEquals(5, myLinkedListDummy.get(1));
    }


    @Test
    public void testTravers() {

        myLinkedListDummy.add(0, 1);
        myLinkedListDummy.add(1, 3);
        myLinkedListDummy.add(2, 5);
        myLinkedListDummy.add(3, 7);
        myLinkedListDummy.add(4, 9);

        // Redirect System.out to a stream for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        myLinkedListDummy.travers();

        assertEquals("1 3 5 7 9", outputStream.toString().trim());
    }
}
