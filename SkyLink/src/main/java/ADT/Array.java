package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Array<T> implements ArrayInterface<T>, Iterable<T> {
    private static final int DEFAULT_CAPACITY = 200;
    private T[] array;
    private int size;

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
	public Array(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive.");
        }
        array = (T[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        ensureCapacity();
        array[size] = newEntry;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null; // Remove reference to the last element
        size--;
        return removedElement;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public T set(int index, T newEntry) {
        checkIndex(index);
        T replacedElement = array[index];
        array[index] = newEntry;
        return replacedElement;
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
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            @SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[2 * size];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
    }

    @Override
    public void addAll(Array<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            add(elements.get(i));
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[currentIndex++];
            }
        };
    }
    
}
