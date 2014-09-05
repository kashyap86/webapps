package org.kash.application.ds.tries;

import java.util.ArrayList;
import java.util.List;

public class BasicTrieNode {

	private List<BasicTrieNode> children;
	private boolean isMarkerNode;
	private String value;
	
	public BasicTrieNode() {
		children = new ArrayList<BasicTrieNode>();
		isMarkerNode = false;
		setValue("");
	}

	public boolean isLeafNode() {
		if(children.isEmpty())
			return true;
		return false;
	}
	
	public BasicTrieNode getChildNode(String s) {
		if(this.getChildren() != null && this.getChildren().size() > 0) {
			for(BasicTrieNode node : this.getChildren()){
				if(node.getValue().equals(s)) {
					return node;
				}
			}
		}
		return null;
	}
	
	public List<BasicTrieNode> getChildren() {
		return children;
	}

	public void setChildren(List<BasicTrieNode> children) {
		this.children = children;
	}
	
	public boolean isMarkerNode() {
		return isMarkerNode;
	}

	public void setMarkerNode(boolean isMarkerNode) {
		this.isMarkerNode = isMarkerNode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
