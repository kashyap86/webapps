package org.kash.application.ds.tries;

import java.util.regex.Pattern;

public class RadixTrie {

	private RadixTrieNode rootNode = null;
	
	public RadixTrie() {
		setRootNode(new RadixTrieNode());
	}
	
	public boolean validateInputForWord(String s) {
		return Pattern.matches("[a-zA-Z]*", s);
	}
	
	public boolean insertWord(String input) {
		RadixTrieNode curNode = rootNode;
		if(input.length() == 0) curNode.setMarkerNode(true);
		if(validateInputForWord(input)) {
			for(int i=0; i<input.length(); i++) {
				String val = input.substring(i, i+1);
				RadixTrieNode targetNode = curNode.getTargetNode(val);
			}
		}
		return false;
	}
	
	public boolean lookupWord(String input) {
		return false;
	}
	
	public boolean deleteWord(String input) {
		return false;
	}

	public RadixTrieNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(RadixTrieNode rootNode) {
		this.rootNode = rootNode;
	}
}
