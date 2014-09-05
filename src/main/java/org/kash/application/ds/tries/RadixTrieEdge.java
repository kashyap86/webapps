package org.kash.application.ds.tries;

public class RadixTrieEdge {

	private RadixTrieNode targetNode;
	private String label;
	
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
