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

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simply returns the size field
     */
    public int getSize() {
        return size;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Simply checks if size is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Delegates to add(0, e) which is O(1) for index 0
     */
    public void addFirst(E e) {
//        Node newNode = new Node(e);
//        newNode.next = head;
//        head = newNode;

//        dummyHead = new Node(e, dummyHead);
//        size++;

        add(0, e);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Traverse to the node at position index-1 (O(n) in worst case)
     * 2. Create new node and link it in (O(1))
     * 
     * Best case: O(1) when adding at index 0
     * Worst case: O(n) when adding at the end
     * Average case: O(n/2) = O(n)
     */
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

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * Delegates to add(size, e) which traverses the entire list
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Traverse to the node at position index-1 (O(n) in worst case)
     * 2. Remove the node and update links (O(1))
     * 
     * Best case: O(1) when removing at index 0
     * Worst case: O(n) when removing at the end
     * Average case: O(n/2) = O(n)
     */
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

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Delegates to remove(0) which is O(1) with dummyHead
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * Delegates to remove(size-1) which traverses to the second-to-last node
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Traverse to the node at position index (O(n) in worst case)
     * 2. Return the element (O(1))
     * 
     * Best case: O(1) when getting index 0
     * Worst case: O(n) when getting the last element
     * Average case: O(n/2) = O(n)
     */
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

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Delegates to get(0) which is O(1) with dummyHead
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * Delegates to get(size-1) which traverses the entire list
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Traverse to the node at position index (O(n) in worst case)
     * 2. Update the element (O(1))
     * 
     * Best case: O(1) when setting index 0
     * Worst case: O(n) when setting the last element
     * Average case: O(n/2) = O(n)
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * Time Complexity: O(n) where n is the number of elements in the list
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Traverse the entire list (O(n))
     * 2. Compare each element with the target (O(1) per comparison)
     * 
     * Best case: O(1) when element is found at the beginning
     * Worst case: O(n) when element is not found or is at the end
     * Average case: O(n/2) = O(n)
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: ");
        
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + " -> ");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
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
        
        // Test 2.5: Get and Set operations
        System.out.println("\n2.5. Testing get and set operations:");
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));
        
        list.set(1, 100);
        System.out.println("After set(1, 100): " + list);
        
        list.set(0, 50);
        System.out.println("After set(0, 50): " + list);
        
        // Test 2.6: Contains operation
        System.out.println("\n2.6. Testing contains operation:");
        System.out.println("Contains 100: " + list.contains(100));
        System.out.println("Contains 15: " + list.contains(15));
        System.out.println("Contains 999: " + list.contains(999));
        
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
        
        // Test 3.5: Get operations after removal
        System.out.println("\n3.5. Testing get operations after removal:");
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 0: " + list.get(0));
        
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
        
        // Test 5: String LinkedList with new operations
        System.out.println("\n5. Testing String LinkedList with new operations:");
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addFirst("Hello");
        stringList.addLast("World");
        stringList.add(1, "Beautiful");
        System.out.println("String list: " + stringList);
        System.out.println("String list size: " + stringList.getSize());
        
        System.out.println("First string: " + stringList.getFirst());
        System.out.println("Last string: " + stringList.getLast());
        System.out.println("Contains 'Hello': " + stringList.contains("Hello"));
        System.out.println("Contains 'Python': " + stringList.contains("Python"));
        
        stringList.set(1, "Amazing");
        System.out.println("After set(1, 'Amazing'): " + stringList);
        
        while (!stringList.isEmpty()) {
            String removed = stringList.removeFirst();
            System.out.println("Removed string: " + removed);
        }
        
        System.out.println("\n=== All tests completed successfully! ===");
    }
}
