package org.kash.application.ds.tries;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicTrieNodeTest {

	private static BasicTrieNode basicTrieNode = null;
	
	@Before
	public void setup() {
		basicTrieNode = new BasicTrieNode();
	}
	
	@Test
	public void testStringConstructor() {
		BasicTrieNode nodeA = new BasicTrieNode("a");
		Assert.assertEquals("a", nodeA.getValue());
	}
	
	@Test
	public void testEmptyConstructor() {
		Assert.assertEquals("", basicTrieNode.getValue());
	}
	
	@Test
	public void existingChildNode() {
		BasicTrieNode nodeA = new BasicTrieNode("a");
		BasicTrieNode nodeB = new BasicTrieNode("b");
		BasicTrieNode nodeC = new BasicTrieNode("c");
		ArrayList<BasicTrieNode> children = new ArrayList<BasicTrieNode>(); 
		children.add(nodeA);
		children.add(nodeB);
		children.add(nodeC);
		basicTrieNode.setChildren(children);
		Assert.assertEquals(nodeA, basicTrieNode.getChildNode("a"));
		Assert.assertEquals(nodeB, basicTrieNode.getChildNode("b"));
		Assert.assertEquals(nodeC, basicTrieNode.getChildNode("c"));
	}
	
	@Test
	public void nonExistingChildNode() {
		Assert.assertNull(basicTrieNode.getChildNode("a"));
	}
	
	@Test
	public void testForNonLeafNode() {
		BasicTrieNode nodeA = new BasicTrieNode("a");
		ArrayList<BasicTrieNode> children = new ArrayList<BasicTrieNode>(); 
		children.add(nodeA);
		basicTrieNode.setChildren(children);
		Assert.assertEquals(false, basicTrieNode.isLeafNode());
	}
	
	@Test
	public void testForLeafNode() {
		Assert.assertEquals(true, basicTrieNode.isLeafNode());
	}
	
	@After
	public void tearDown() {
		basicTrieNode = null;
	}
}
