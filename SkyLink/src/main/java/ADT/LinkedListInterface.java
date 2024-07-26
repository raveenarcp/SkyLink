package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface LinkedListInterface<T> {

    void addFirst(T e);

    void addLast(T e);

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();

    boolean isEmpty();

    int size();

    void clear();

    Iterator<T> iterator();
}
