package DataStructures;

public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        array = new Object[initialCapacity];
        size = 0;
    }

    public void push(T item) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) array[--size];
        array[size] = null; // Dereference to help garbage collection
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resizeArray() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}

