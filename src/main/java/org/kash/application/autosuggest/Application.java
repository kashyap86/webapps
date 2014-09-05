package org.kash.application.autosuggest;

import org.kash.application.ds.tries.BasicTrie;

public class Application {

	public static void main( String[] args ) {
		System.out.println( "Hello World!" );
        BasicTrie trie = new BasicTrie();
        if(trie.insertWord("first")) {
        	System.out.println("Inserted successfully.");
        	System.out.println(trie.lookupWord("first"));
        }
	}
}
