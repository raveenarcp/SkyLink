package ADT; 
import java.util.NoSuchElementException;

public class LinkedList<T> implements Deque<T> {

    class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
            prev = next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedList() {
        front = rear = null;
        size = 0;
    }

    @Override
    public void addToFront(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    @Override
    public void addToBack(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T data = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return data;
    }

    @Override
    public T removeFromBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T data = rear.data;
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return data;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return front.data;
    }

    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return rear.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = rear = null;
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        Node current = front;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}