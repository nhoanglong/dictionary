package com.greenstack.dictionary.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.greenstack.dictionary.TrieDictionary;
import com.greenstack.dictionary.VocabularyDictionary;

/**
 * A utility to save and load data into/from file
 * 
 * @author nhoanglong
 * @version 1.0
 */
public class FileStorage {
	private static final String FILENAME = "vocabulary.txt";

	/**
	 * Save data into file
	 * 
	 * @param dict
	 */
	public void saveIntoFile(VocabularyDictionary dict) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = dict.getAllVocabularies();

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Completed save into file...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Load Dictionary from file
	 * 
	 * @return VocabularyDictionary
	 */
	public VocabularyDictionary loadDictionary() {
		VocabularyDictionary dict = new TrieDictionary();
		BufferedReader br = null;
		FileReader fr = null;

		try {
			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			int lineCount = 0;
			String sCurrentLine;
			String word = null;
			StringBuilder meaning = new StringBuilder();
			while ((sCurrentLine = br.readLine()) != null) {
				if ("&nbsp;".equals(sCurrentLine)) {// end of word and meaning
					dict.insertOrUpdateVocabulary(word, meaning.toString());
					// re-init word and meaning
					word = null;
					meaning.setLength(0);
				} else {// the start word or continue meaning
					if (lineCount == 0 || word == null) {
						word = sCurrentLine;
					} else {
						// append new line into meaning
						meaning.append(sCurrentLine + "\n");
					}
				}
				lineCount++;
			}
			System.out.println("Completed loading Dictionary from file...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

		return dict;
	}
}
