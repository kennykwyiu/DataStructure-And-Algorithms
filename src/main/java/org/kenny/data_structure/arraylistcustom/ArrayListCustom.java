package org.kenny.data_structure.arraylistcustom;

public class ArrayListCustom {
    private int[] items;
    private int count;

    public ArrayListCustom(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[(int) (count * 1.5)];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public int get(int index) {
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

    public int indexOf(int item) {
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

    public int getSize() {
        return count;
    }

    public int getItemCapacity() {
        return items.length;
    }
}
