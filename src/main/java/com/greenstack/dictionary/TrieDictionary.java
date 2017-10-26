package com.greenstack.dictionary;

import java.util.HashMap;
import java.util.Map;

import com.greenstack.dictionary.utils.AlphabetTrie;
import com.greenstack.dictionary.utils.TrieNode;

/**
 * class TrieDictionary
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class TrieDictionary extends AlphabetTrie implements VocabularyDictionary {

	// This is an fast-access to collect all words and meanings for fast save
	// into DB,
	// instead of travel the trie tree
	private Map<String, String> words = new HashMap<String, String>();

	public TrieDictionary() {
		root = new VocabularyNode(); // root is VocabularyNode now
	}

	@Override
	protected TrieNode createNewNode() {
		return new VocabularyNode();
	}

	/**
	 * Insert or update vocabulary for dictionary
	 * 
	 * @param word
	 * @param meaning
	 */
	public void insertOrUpdateVocabulary(String word, String meaning) {
		VocabularyNode node = (VocabularyNode) super.insert(word);
		// if(node != null) {
		node.setMeaning(meaning);
		words.put(word, meaning);
		// }
	}

	/**
	 * Look up the input vocabulary
	 * 
	 * @param word
	 * @return String
	 */
	public String lookupVocabulary(String word) {
		VocabularyNode node = (VocabularyNode) super.searchNode(word);
		if (node != null && node.isWordEnd()) {
			return word + ": " + node.getMeaning();
		} else {
			return "Can't find meaning of \"" + word + "\"!";
		}
	}

	public Map<String, String> getWords() {
		return words;
	}

	public void setWords(Map<String, String> words) {
		this.words = words;
	}

	/**
	 * Delete the input vocabulary
	 * 
	 * @param word
	 */
	public void deleteVocabulary(String word) {
		VocabularyNode node = (VocabularyNode) super.searchNode(word);
		if (node != null && node.isWordEnd()) {
			node.setMeaning(null);
			node.setWordEnd(false);
			words.remove(word);
			System.out.println("Succeeding delete \"" + word + "\"!");
		} else {
			System.out.println("Can't find \"" + word + "\"!");
		}
	}

	/**
	 * Get all vocabularies
	 * 
	 * @param word
	 * @return String
	 */
	public String getAllVocabularies() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : words.entrySet()) {
			sb.append(entry.getKey() + "\n" + entry.getValue() + "&nbsp;\n");
		}
		return sb.toString();
	}
}
