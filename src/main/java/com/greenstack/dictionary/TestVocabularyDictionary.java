package com.greenstack.dictionary;

import com.greenstack.dictionary.utils.FileStorage;

/**
 * Test Dictionary implemented by trie tree
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class TestVocabularyDictionary {
	public static void main(String[] args) {
		FileStorage fs = new FileStorage();
		VocabularyDictionary dict = fs.loadDictionary();
		dict.insertOrUpdateVocabulary("teacher", "A trainer who teaches student");
		dict.insertOrUpdateVocabulary("family", "Include husband and wife or blood-bond persons");
		dict.insertOrUpdateVocabulary("new", "an unseen thing\nbrand new thing");

		System.out.println(dict.lookupVocabulary("teacher"));
		System.out.println(dict.lookupVocabulary("teach"));
		System.out.println(dict.lookupVocabulary("tea"));
		System.out.println(dict.lookupVocabulary("family"));
		System.out.println(dict.lookupVocabulary("new"));

		// System.out.println(dict.getAllVocabularies());

		// dict.deleteVocabulary("new");
		// System.out.println(dict.lookupVocabulary("teacher"));
		// System.out.println(dict.getAllVocabularies());

		fs.saveIntoFile(dict);
	}

}
