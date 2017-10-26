package com.greenstack.dictionary.utils;

/**
 * Alphabet trie tree data structure
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class AlphabetTrie {
	protected TrieNode root;

	public AlphabetTrie() {
		root = new TrieNode();
	}

	/**
	 * insert new node or update to latest child node
	 * 
	 * @param word
	 * @return TrieNode
	 */
	protected TrieNode insert(String word) {
		TrieNode p = root;
		word = word.toLowerCase();
		System.out.println(word);
		if (!validate(word)) {
			System.out.println(word);
			return null;
		}

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a'; // ASCII value
			if (p.getChildNodes()[index] == null) {
				TrieNode temp = createNewNode(); // create new node, depends of
													// purpose
				p.getChildNodes()[index] = temp;
				p = temp;
			} else {
				p = p.getChildNodes()[index];
			}
		}
		p.setWordEnd(true);// indicate this word is a complete word, not prefix
		return p;
	}

	/**
	 * Validate input word 
	 * Returns true of word contains only a-z chars 
	 * Returns false in reverse case
	 *
	 * @param word
	 * @return boolean
	 */
	private boolean validate(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int asciiValue = (int) c;
			if (asciiValue < 97 || asciiValue > 122) {
				System.out.println("Validation failed! Word contains a-z only");
				return false;
			}
		}
		return true;
	}

	/**
	 * Create new node Depends on requirements, we could have multiple kinds of
	 * Node
	 * 
	 * @return
	 */
	protected TrieNode createNewNode() {
		return new TrieNode();
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode p = searchNode(word);
		if (p == null) {
			return false;
		} else {
			if (p.isWordEnd())
				return true;
		}

		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode p = searchNode(prefix);
		if (p == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * return a TrieNode by inputting a specific word
	 * 
	 * @param word
	 * @return TrieNode
	 */
	public TrieNode searchNode(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (p.getChildNodes()[index] != null) {
				p = p.getChildNodes()[index];
			} else {
				return null;
			}
		}

		if (p == root)
			return null;

		return p;
	}
}
