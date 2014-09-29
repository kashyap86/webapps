package org.kash.application.autosuggest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.kash.application.ds.tries.BasicTrie;

public class Application {

	public static void main( String[] args ) {
		System.out.println( "Hello World!" );
		BasicTrie trie = new BasicTrie();
		BufferedReader br;
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("src/main/resources/BoggleDictionary.txt"));
			InputStreamReader is = new InputStreamReader(fis);
			br = new BufferedReader(is);
			String line = "";
			while((line = br.readLine()) != null) {
				trie.insertWord(line);
			}
			System.out.println("Created trie successfully.");
			fis.close();
			is.close();
			br.close();
			List<String> possibleWords = trie.traverseTrieForPossibleWords("pep");
			System.out.println(possibleWords.size());
			for(String word : possibleWords) {
				System.out.println(word + " - isWord? : " + trie.lookupWord(word));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException.");
			e.printStackTrace();
		}
	}
}
