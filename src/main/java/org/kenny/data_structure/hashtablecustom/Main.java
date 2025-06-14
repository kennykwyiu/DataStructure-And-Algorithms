package org.kenny.data_structure.hashtablecustom;

public class Main {
    public static void main(String[] args) {
        // HashTable
        // put(k,v)
        // get(K): v
        // remove(K)
        // k: int
        // v: string
        // Collisions: chaining
        // So, instead of storing these key value pairs inside array
        // we want to store them in LinkedList
        // Entry - should have two fields, key and value
        // LinkedList<Entry> [] to hold the Entry Class
        HashTable table = new HashTable();
        table.put(6, "A"); // 1
        table.put(8, "B"); // 3
        table.put(11, "C"); // 1
        table.put(6, "A+"); // 1
//        table.remove(6);
        System.out.println(table.get(6));


    }
}
