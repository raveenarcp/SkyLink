package ADT;

import java.util.NoSuchElementException;

public interface Deque<T> {
    /**
     * Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions.
     *
     * @param element the element to add
     */
    void addToFront(T element);

    /**
     * Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions.
     *
     * @param element the element to add
     */
    void addToBack(T element);

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     *
     * @return the first element of this deque, or null if this deque is empty
     */
    T removeFromFront();

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     *
     * @return the last element of this deque, or null if this deque is empty
     */
    T removeFromBack();

    /**
     * Retrieves, but does not remove, the first element of this deque.
     *
     * @return the first element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    T getFront();

    /**
     * Retrieves, but does not remove, the last element of this deque.
     *
     * @return the last element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    T getBack();

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    int size();

    /**
     * Removes all of the elements from this deque. The deque will be empty after this call returns.
     */
    void clear();

    /**
     * Checks whether the deque contains the specified element.
     *
     * @param element the element to search for
     * @return true if the deque contains the element, false otherwise
     */
    boolean contains(T element);

    /**
     * Checks whether the deque is empty.
     *
     * @return true if the deque is empty, false otherwise
     */
    boolean isEmpty();
}