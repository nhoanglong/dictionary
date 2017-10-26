package com.greenstack.dictionary.utils;

/**
 * TrieNode class This class is trie node implementation for trie tree data
 * structure
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class TrieNode {
	protected TrieNode[] childNodes; // children nodes
	private boolean isWordEnd; // indicate a complete word

	// Initialize data structure here.
	public TrieNode() {
		this.childNodes = new TrieNode[26];
	}

	public TrieNode[] getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(TrieNode[] childNodes) {
		this.childNodes = childNodes;
	}

	public boolean isWordEnd() {
		return isWordEnd;
	}

	public void setWordEnd(boolean isWordEnd) {
		this.isWordEnd = isWordEnd;
	}
}
