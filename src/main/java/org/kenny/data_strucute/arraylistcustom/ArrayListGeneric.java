package org.kenny.data_strucute.arraylistcustom;

public class ArrayListGeneric<T> {
    private T[] items;
    private int count;

    public ArrayListGeneric(int length) {
        items = (T[]) new Object[length];
    }

    public void insert(T item) {
        if (items.length == count) {
            T[] newItems = (T[]) new Object[(int) (count * 1.5)];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid index!");
        }
        return items[index];
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Pls insert correct index!!!");
        }
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(T item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
