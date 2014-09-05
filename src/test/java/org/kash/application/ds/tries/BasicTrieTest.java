package org.kash.application.ds.tries;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicTrieTest {
	
	private BasicTrie basicTrie = null;
	private static final String LOOKUP_WORD = "search";
	private static final String NON_LOOKUP_WORD = "abc";
	private static final String DELETE_WORD = "delete";
 	
	@Before
	public void setup(){
		basicTrie = new BasicTrie();
	}

	@Test
	public void rootNodeIsNotNull() {
		Assert.assertNotNull(basicTrie.getRootNode());
	}
	
	@Test
	public void insertValidWord() {
		Assert.assertEquals(true, basicTrie.insertWord("first"));
		Assert.assertEquals(true, basicTrie.insertWord(""));
	}
	
	@Test
	public void insertInvalidWord() {
		Assert.assertEquals(false, basicTrie.insertWord("invalid word"));
	}
	
	@Test
	public void validInput() {
		Assert.assertEquals(true, basicTrie.validateInputForWord("correct"));
	}
	
	@Test
	public void invalidInput() {
		Assert.assertEquals(false, basicTrie.validateInputForWord("Incorrect input - invalid input."));
	}
	
	@Test
	public void lookupExistingWord() {
		basicTrie.insertWord(LOOKUP_WORD);
		Assert.assertEquals(true, basicTrie.lookupWord(LOOKUP_WORD));
	}
	
	@Test
	public void lookupNonExistingWord() {
		Assert.assertEquals(false, basicTrie.lookupWord(NON_LOOKUP_WORD));
	}
	
	@Test
	public void deleteExistingWord() {
		basicTrie.insertWord(DELETE_WORD);
		Assert.assertEquals(true, basicTrie.lookupWord(DELETE_WORD));
		Assert.assertEquals(true, basicTrie.deleteWord(DELETE_WORD));
		Assert.assertEquals(false, basicTrie.lookupWord(DELETE_WORD));
		basicTrie.insertWord("guilts");
		basicTrie.insertWord("guilty");
		Assert.assertEquals(true, basicTrie.lookupWord("guilts"));
		Assert.assertEquals(true, basicTrie.lookupWord("guilty"));
		Assert.assertEquals(true, basicTrie.deleteWord("guilts"));
		Assert.assertEquals(false, basicTrie.lookupWord("guilts"));
		Assert.assertEquals(true, basicTrie.lookupWord("guilty"));
	}
	
	@After
	public void tearDown() {
		basicTrie = null;
	}
}
