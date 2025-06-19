package org.kenny.data_structure.course.datastrutures.queue;

public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        array = new DynamicArray<>();
    }

    // O(1)
    @Override
    public int getSize() {
        return array.getSize();
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    // O(1)
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // O(n)
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    // O(1)
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
