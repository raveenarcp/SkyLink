package ADT;

import java.util.Collection;

/**
 * An interface that describes the operations of a HashSet data structure.
 */
public interface HashSetInterface<T> {

    /**
     * Adds the specified element to this set if it is not already present.
     * @param element The element to be added to the set.
     * @return True if this set did not already contain the specified element, false otherwise.
     */
    public boolean add(T element);

    /**
     * Removes the specified element from this set if it is present.
     * @param element The element to be removed from the set.
     * @return True if this set contained the specified element, false otherwise.
     */
    public boolean remove(T element);

    /**
     * Returns true if this set contains the specified element.
     * @param element The element whose presence in this set is to be tested.
     * @return True if this set contains the specified element, false otherwise.
     */
    public boolean contains(T element);

    /**
     * Returns the number of elements in this set.
     * @return The number of elements in this set.
     */
    public int size();

    /**
     * Removes all of the elements from this set.
     */
    public void clear();

    /**
     * Returns true if this set contains no elements.
     * @return True if this set contains no elements.
     */
    public boolean isEmpty();

    /**
     * Adds all of the elements in the specified collection to this set.
     * @param elements The collection containing elements to be added to this set.
     * @return True if this set changed as a result of the call, false otherwise.
     */
    public boolean addAll(Collection<? extends T> elements);

    /**
     * Removes from this set all of its elements that are contained in the specified collection.
     * @param elements The collection containing elements to be removed from this set.
     * @return True if this set changed as a result of the call, false otherwise.
     */
    public boolean removeAll(Collection<?> elements);

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     * @param elements The collection containing elements to be retained in this set.
     * @return True if this set changed as a result of the call, false otherwise.
     */
    public boolean retainAll(Collection<?> elements);
}
