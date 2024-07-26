package ADT;

import java.util.Collection;

public class HashSet<T> implements HashSetInterface<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<T>[] buckets;
    private int size;

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private int hash(T element) {
        return Math.abs(element.hashCode() % buckets.length);
    }

    @Override
    public boolean add(T element) {
        int index = hash(element);
        Node<T> node = buckets[index];
        while (node != null) {
            if (node.element.equals(element)) {
                return false; // Element already exists, cannot add
            }
            node = node.next;
        }
        Node<T> newNode = new Node<>(element);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
        return true; // Element added successfully
    }

    private void resize() {
        Node<T>[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;
        for (Node<T> node : oldBuckets) {
            while (node != null) {
                add(node.element);
                node = node.next;
            }
        }
    }

    @Override
    public boolean remove(T element) {
        int index = hash(element);
        Node<T> prev = null;
        Node<T> current = buckets[index];
        while (current != null) {
            if (current.element.equals(element)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true; // Element removed successfully
            }
            prev = current;
            current = current.next;
        }
        return false; // Element not found, cannot remove
    }

    @Override
    public boolean contains(T element) {
        int index = hash(element);
        Node<T> node = buckets[index];
        while (node != null) {
            if (node.element.equals(element)) {
                return true; // Element found
            }
            node = node.next;
        }
        return false; // Element not found
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new Node[buckets.length];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> elements) {
        boolean modified = false;
        for (T element : elements) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> elements) {
        boolean modified = false;
        for (Object element : elements) {
            if (remove((T) element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> elements) {
        boolean modified = false;
        for (Node<T> node : buckets) {
            Node<T> prev = null;
            Node<T> current = node;
            while (current != null) {
                if (!elements.contains(current.element)) {
                    if (prev == null) {
                        buckets[hash(current.element)] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    modified = true;
                } else {
                    prev = current;
                }
                current = current.next;
            }
        }
        return modified;
    }
}
