package ADT;

import java.util.Iterator;

/**
 * An interface that describes the operations of an array of objects.
 */
public interface ArrayInterface<T> {

    /**
     * Adds a new entry to the end of this array.
     * @param newEntry An object to be added to the array.
     */
    public void add(T newEntry);

    /**
     * Removes and returns the entry at a specified index in this array.
     * @param index The index of the entry to be removed.
     * @return The object removed from the array.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public T remove(int index);

    /**
     * Retrieves the entry at a specified index in this array.
     * @param index The index of the entry to retrieve.
     * @return The object at the specified index in the array.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public T get(int index);

    /**
     * Replaces the entry at a specified index in this array with the specified entry.
     * @param index The index of the entry to replace.
     * @param newEntry The object to be stored at the specified index.
     * @return The original object that was replaced.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    public T set(int index, T newEntry);

    /**
     * Detects whether this array is empty.
     * @return True if the array has no entries.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this array.
     * @return The number of elements in the array.
     */
    public int size();

    /**
     * Removes all entries from this array.
     */
    public void clear();
    
    /**
     * Adds new elements to the end of this array.
     * @param elements is An object to be added to the array.
     */
    public void addAll(Array<T> elements);

	Iterator<T> iterator();

}
