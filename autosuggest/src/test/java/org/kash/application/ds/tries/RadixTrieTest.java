package org.kash.application.ds.tries;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RadixTrieTest {

	private static RadixTrie radixTrie = null;
	private static final String LOOKUP_WORD = "search";
	private static final String NON_LOOKUP_WORD = "abc";
	private static final String DELETE_WORD = "delete";
	
	@Before
	public void setup() {
		radixTrie = new RadixTrie();
	}
	
	@Test
	public void rootNodeIsNotNull() {
		Assert.assertNotNull(radixTrie.getRootNode());
	}
	
	@Test
	public void insertValidWord() {
		Assert.assertEquals(true, radixTrie.insertWord("first"));
		Assert.assertEquals(true, "");
	}
	
	@Test
	public void insertInvalidWord() {
		Assert.assertEquals(false, radixTrie.insertWord("invalid input"));
	}
	
	@Test
	public void validInput() {
		Assert.assertEquals(true, radixTrie.validateInputForWord("correct"));
	}
	
	@Test
	public void invalidInput() {
		Assert.assertEquals(false, radixTrie.validateInputForWord("Incorrect input - invalid input."));
	}
	
	@Test
	public void lookupExistingWord() {
		radixTrie.insertWord(LOOKUP_WORD);
		Assert.assertEquals(true, radixTrie.lookupWord(LOOKUP_WORD));
	}
	
	@Test
	public void lookupNonExistingWord() {
		Assert.assertEquals(false, radixTrie.lookupWord(NON_LOOKUP_WORD));
	}
	
	@Test
	public void deleteExistingWord() {
		radixTrie.insertWord(DELETE_WORD);
		Assert.assertEquals(true, radixTrie.lookupWord(DELETE_WORD));
		Assert.assertEquals(true, radixTrie.deleteWord(DELETE_WORD));
		Assert.assertEquals(false, radixTrie.lookupWord(DELETE_WORD));
	}
	
	
	@After
	public void tearDown() {
		radixTrie = null;
	}
}
