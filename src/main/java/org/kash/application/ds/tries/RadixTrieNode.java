package org.kash.application.ds.tries;

public class RadixTrieNode {

	private RadixTrieEdge[] edges;

	public boolean isLeafNode() {
		if(this.edges == null)
			return true;
		if(this.edges != null && this.edges.length == 0)
			return true;
		return false;
	}
	
	public RadixTrieEdge[] getEdges() {
		return edges;
	}

	public void setEdges(RadixTrieEdge[] edges) {
		this.edges = edges;
	}
	
}
