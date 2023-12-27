package org.kenny.data_strucute.tree;

public class TreeNodeGeneric<T> {
    public T value;
    public TreeNodeGeneric<T> left;
    public TreeNodeGeneric<T> right;

    public TreeNodeGeneric(T value) {
        this.value = value;
    }
}
