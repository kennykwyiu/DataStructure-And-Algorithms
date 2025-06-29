package org.kenny.data_structure.course.datastrutures.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node newNode = new Node(e);
//        newNode.next = head;
//        head = newNode;

//        dummyHead = new Node(e, dummyHead);
//        size++;

        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: ");
        
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        
        return res.toString();
    }

    // Test case for LinkedList
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("=== LinkedList Test Cases ===");

        // Test 1: Empty list operations
        System.out.println("\n1. Testing empty list:");
        System.out.println("Size: " + list.getSize());
        System.out.println("Is empty: " + list.isEmpty());

        // Test 2: Add operations
        System.out.println("\n2. Testing add operations:");
        list.addFirst(10);
        System.out.println("After addFirst(10): Size = " + list.getSize());

        list.addLast(20);
        System.out.println("After addLast(20): Size = " + list.getSize());

        list.add(1, 15);
        System.out.println("After add(1, 15): Size = " + list.getSize());

        list.addFirst(5);
        System.out.println("After addFirst(5): Size = " + list.getSize());

        list.addLast(25);
        System.out.println("After addLast(25): Size = " + list.getSize());
        System.out.println(list);

        // Test 3: Remove operations
        System.out.println("\n3. Testing remove operations:");
        System.out.println("Current size: " + list.getSize());

        int first = list.removeFirst();
        System.out.println("Removed first: " + first + ", Size = " + list.getSize());
        System.out.println(list);

        int last = list.removeLast();
        System.out.println("Removed last: " + last + ", Size = " + list.getSize());
        System.out.println(list);

        int middle = list.remove(1);
        System.out.println("Removed at index 1: " + middle + ", Size = " + list.getSize());
        System.out.println(list);

        // Test 4: Edge cases
        System.out.println("\n4. Testing edge cases:");
        list.addFirst(100);
        list.addLast(200);
        System.out.println("After adding more elements: Size = " + list.getSize());
        System.out.println(list);

        // Remove all elements
        while (!list.isEmpty()) {
            int removed = list.removeFirst();
            System.out.println("Removed: " + removed + ", Remaining size: " + list.getSize());
            System.out.println(list);
        }

        System.out.println("Final size: " + list.getSize());
        System.out.println("Is empty: " + list.isEmpty());

        // Test 5: String LinkedList
        System.out.println("\n5. Testing String LinkedList:");
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addFirst("Hello");
        stringList.addLast("World");
        stringList.add(1, "Beautiful");
        System.out.println("String list size: " + stringList.getSize());
        System.out.println(list);

        while (!stringList.isEmpty()) {
            String removed = stringList.removeFirst();
            System.out.println("Removed string: " + removed);
            System.out.println("Removed string: " + removed);
        }

        System.out.println("\n=== All tests completed successfully! ===");
    }
}
