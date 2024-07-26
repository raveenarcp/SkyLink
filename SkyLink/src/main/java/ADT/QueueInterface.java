package ADT;

import java.util.NoSuchElementException;

public interface QueueInterface<T> {
    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     * 
     * @param element the element to add
     * @return true if the element was added to this queue, else false
     */
    boolean offer(T element);

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * 
     * @return the head of this queue, or null if this queue is empty
     */
    T poll();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * 
     * @return the head of this queue, or null if this queue is empty
     */
    T peek();

    /**
     * Retrieves and removes the head of this queue. This method differs from poll() only in that it throws an exception if this queue is empty.
     * 
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    T remove();

    /**
     * Retrieves, but does not remove, the head of this queue. This method differs from peek() only in that it throws an exception if this queue is empty.
     * 
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    T element();

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Removes all of the elements from this queue. The queue will be empty after this call returns.
     */
    void clear();
}
