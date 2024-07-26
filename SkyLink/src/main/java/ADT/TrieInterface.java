package ADT;

/**
 * Interface for a Trie data structure, which is used to store a set of strings.
 */
public interface TrieInterface {

    /**
     * Inserts a word into the trie.
     * @param word The word to insert.
     */
    void insert(String word);

    /**
     * Searches for a word in the trie.
     * @param word The word to search for.
     * @return true if the word is in the trie, false otherwise.
     */
    boolean search(String word);

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * @param prefix The prefix to check.
     * @return true if there is any word in the trie that starts with the given prefix, false otherwise.
     */
    boolean startsWith(String prefix);

    /**
     * Removes a word from the trie. Returns true if the word was successfully removed, false if the word was not found.
     * @param word The word to remove.
     * @return true if the word was removed successfully, false if the word was not found.
     */
    boolean delete(String word);

    /**
     * Returns the number of words in the trie.
     * @return the number of words stored in the trie.
     */
    int size();

    /**
     * Checks if the trie is empty.
     * @return true if the trie has no words, false otherwise.
     */
    boolean isEmpty();
}
