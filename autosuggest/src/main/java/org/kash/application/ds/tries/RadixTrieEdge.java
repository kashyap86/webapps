package org.kash.application.ds.tries;

public class RadixTrieEdge {

	private RadixTrieNode targetNode;
	private String label;
	
	public RadixTrieEdge(String label) {
		this.label = label;
		targetNode = new RadixTrieNode();
	}
	
	public RadixTrieEdge (String label, RadixTrieNode targetNode) {
		this.label = label;
		this.targetNode = targetNode;
	}
	
	public RadixTrieNode getTargetNode() {
		return targetNode;
	}
	public void setTargetNode(RadixTrieNode targetNode) {
		this.targetNode = targetNode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
