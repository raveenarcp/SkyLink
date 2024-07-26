package ADT;

import java.util.NoSuchElementException;

public class Queue<T> implements QueueInterface<T> {
    private static final int DEFAULT_CAPACITY = 200;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }
        array = new Object[initialCapacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public boolean offer(T element) {
        if (size == array.length) {
            expandCapacity();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T element = getElementAtFront();
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return getElementAtFront();
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return poll();
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return getElementAtFront();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        front = 0;
        rear = -1;
    }

    private void expandCapacity() {
        Object[] newArray = new Object[array.length * 2];
        int current = front;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[current];
            current = (current + 1) % array.length;
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }

    @SuppressWarnings("unchecked")
    private T getElementAtFront() {
        return (T) array[front];
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
