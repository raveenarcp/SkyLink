package ADT;

import java.util.Collection;
import java.util.Set;

/**
 * An interface that describes the operations of a HashMap data structure.
 */
public interface HashMapInterface<K, V> {

    /**
     * Associates the specified value with the specified key in this map.
     * @param key The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     * @return The previous value associated with the specified key, or null if there was no mapping for the key.
     */
    public V put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @param key The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(K key);

    /**
     * Removes the mapping for a key from this map if it is present.
     * @param key The key whose mapping is to be removed from the map.
     * @return The previous value associated with the specified key, or null if there was no mapping for the key.
     */
    public V remove(K key);

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key The key whose presence in this map is to be tested.
     * @return True if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key);

    /**
     * Returns a Set view of the keys contained in this map.
     * @return A set view of the keys contained in this map.
     */
    public Set<K> keySet();

    /**
     * Returns a Collection view of the values contained in this map.
     * @return A collection view of the values contained in this map.
     */
    public Collection<V> values();

    /**
     * Returns the number of key-value mappings in this map.
     * @return The number of key-value mappings in this map.
     */
    public int size();

    /**
     * Removes all of the mappings from this map.
     */
    public void clear();

    /**
     * Returns true if this map contains no key-value mappings.
     * @return True if this map contains no key-value mappings.
     */
    public boolean isEmpty();

	V putIfAbsent(K key, V value);

}
