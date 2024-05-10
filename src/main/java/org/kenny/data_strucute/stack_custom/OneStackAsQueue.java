package org.kenny.data_strucute.stack_custom;

public class OneStackAsQueue<E> implements MyCustomQueue<E> {
    private final MyStack<E> stack;

    public OneStackAsQueue() {
        this.stack = new MyStack<>();
    }

    @Override
    public boolean offer(E e) {
        stack.push(e);
        return true;
    }

    @Override
    public E poll() {
        if (stack.isEmpty()) {
            return null;
        }
        E removedData = stack.pop();
        if (!stack.isEmpty()) {
            E removeAgainData = poll();
            stack.push(removeAgainData);
            return removeAgainData;
        }
        return removedData;
    }
}
