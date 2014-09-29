package org.kash.application.autosuggest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
			System.out.println("Lookup the word first:" + trie.lookupWord("first"));
			fis.close();
			is.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException.");
			e.printStackTrace();
		}
	}
}
