package org.kash.application.ds.tries;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RadixTrieNodeTest {

	private static RadixTrieNode radixTrieNode = null;
	
	@Before
	public void setup() {
		radixTrieNode = new RadixTrieNode();
	}
	
	@Test
	public void existingTargetNode() {
		RadixTrieEdge edgeA = new RadixTrieEdge("a");
		RadixTrieEdge edgeBC = new RadixTrieEdge("bc");
		List<RadixTrieEdge> edges = new ArrayList<RadixTrieEdge>();
		edges.add(edgeA);
		edges.add(edgeBC);
		radixTrieNode.setEdges(edges);
		Assert.assertNotNull(radixTrieNode.getTargetNode("a"));
		Assert.assertNotNull(radixTrieNode.getTargetNode("bc"));
	}
	
	@After
	public void tearDown() {
		radixTrieNode = null;
	}
}
