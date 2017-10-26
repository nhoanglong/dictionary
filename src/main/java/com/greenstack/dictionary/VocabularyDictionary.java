package com.greenstack.dictionary;

/**
 * Interface VocabularyDictionary
 * 
 * @author nhoanglong
 * @version 1.0
 */
public interface VocabularyDictionary {
	/**
	 * Insert or update vocabulary for dictionary
	 * 
	 * @param word
	 * @param meaning
	 */
	public void insertOrUpdateVocabulary(String word, String meaning);

	/**
	 * Look up the input vocabulary
	 * 
	 * @param word
	 * @return String
	 */
	public String lookupVocabulary(String word);

	/**
	 * Delete the input vocabulary
	 * 
	 * @param word
	 */
	public void deleteVocabulary(String word);

	/**
	 * Get all vocabularies
	 * 
	 * @return String
	 */
	public String getAllVocabularies();
}
