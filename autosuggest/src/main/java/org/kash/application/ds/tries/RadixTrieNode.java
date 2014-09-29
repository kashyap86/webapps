package org.kash.application.ds.tries;

import java.util.ArrayList;
import java.util.List;

public class RadixTrieNode {

	private List<RadixTrieEdge> edges;
	private boolean isMarkerNode;

	public RadixTrieNode() {
		edges = new ArrayList<RadixTrieEdge>();
		isMarkerNode = false;
	}
	
	public boolean isLeafNode() {
		if(this.edges == null || this.edges.isEmpty())
			return true;
		return false;
	}
	
	public RadixTrieNode getTargetNode(String s) {
		for(RadixTrieEdge edge : this.edges) {
			if(edge.getLabel().equals(s))
				return edge.getTargetNode();
		}
		return null;
	}
	
	public List<RadixTrieEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<RadixTrieEdge> edges) {
		this.edges = edges;
	}

	public boolean isMarkerNode() {
		return isMarkerNode;
	}

	public void setMarkerNode(boolean isMarkerNode) {
		this.isMarkerNode = isMarkerNode;
	}
	
}
