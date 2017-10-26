package com.greenstack.dictionary.utils;

public class TestTrie {

	public static void main(String[] args) {
		AlphabetTrie at = new AlphabetTrie();
		at.insert("concu");
		System.out.println(at.startsWith("con"));
		System.out.println(at.startsWith("cu"));
		System.out.println(at.startsWith("c"));
	}

}
