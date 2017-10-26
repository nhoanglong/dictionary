package com.greenstack.dictionary;

import com.greenstack.dictionary.utils.TrieNode;

/**
 * class VocabularyNode An extension of Trie Node, this vocabulary node has
 * meaning of word also
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class VocabularyNode extends TrieNode {
	private String meaning;

	public VocabularyNode() {
		this.childNodes = new VocabularyNode[26];
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
