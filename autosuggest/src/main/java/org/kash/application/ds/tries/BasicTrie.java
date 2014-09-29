package org.kash.application.ds.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BasicTrie {

	private BasicTrieNode rootNode = null;

	public BasicTrie(){
		rootNode = new BasicTrieNode();
	}

	public boolean insertWord(String s) {
		BasicTrieNode curNode = rootNode;
		if(s.length() == 0) curNode.setMarkerNode(true);
		if(validateInputForWord(s)){
			s = s.toLowerCase();
			for(int i = 0; i<s.length(); i++) {
				String val = s.substring(i, i+1);
				BasicTrieNode childNode = curNode.getChildNode(val);
				if(childNode == null) {
					BasicTrieNode newNode = new BasicTrieNode();
					newNode.setValue(val);
					curNode.getChildren().add(newNode);
					curNode = curNode.getChildNode(val);
				} else {
					curNode = childNode;
				}
				if(i == s.length() -1)
					curNode.setMarkerNode(true);
			}
			return true;
		}
		return false;

	}

	public boolean validateInputForWord(String s) {
		return Pattern.matches("[a-zA-Z]*", s);
	}

	public boolean lookupWord(String s) {

		s = s.toLowerCase();
		BasicTrieNode curNode = getRootNode();
		if(curNode.getChildren() == null && s.length() > 0)
			return false;
		curNode = traverseTrieForWord(s, curNode);
		if(curNode != null && curNode.isMarkerNode())
			return true;
		return false;

	}

	private BasicTrieNode traverseTrieForWord(String s, BasicTrieNode curNode) {
		for(int i = 0; i<s.length(); i++) {
			curNode = getChildNodeByVal(s, curNode, i);
			if(curNode == null)
				break;
		}
		return curNode;
	}
	
	private BasicTrieNode traverseTrieForInputString(String s, BasicTrieNode curNode) {
		for(int i = 0; i<s.length(); i++) {
			curNode = getChildNodeByVal(s, curNode, i);
		}
		return curNode;
	}
	
	public List<String> traverseTrieForPossibleWords(String s) {
		List<String> possibleWords = new ArrayList<String>();
		BasicTrieNode curNode = getNodeForInputString(s);
		if(curNode != null)
			getAllSuffixesFromCurrentNode(curNode, s, possibleWords);
		return possibleWords;
	}
	
	private void getAllSuffixesFromCurrentNode(BasicTrieNode curNode,
			String s, List<String> possibleWords) {
		for(BasicTrieNode node : curNode.getChildren()) {
			String suffixSoFar = s+node.getValue();
			if(node.isMarkerNode()) {
				possibleWords.add(suffixSoFar);
			}
			if(node.getChildren() != null) {
				getAllSuffixesFromCurrentNode(node, suffixSoFar, possibleWords);
			}
		}
	}

	public BasicTrieNode getNodeForInputString(String s) {
		s = s.toLowerCase();
		BasicTrieNode curNode = getRootNode();
		if(curNode.getChildren() == null && s.length() > 0)
			return null;
		curNode = traverseTrieForInputString(s, curNode);
		return curNode;
	}

	private BasicTrieNode getChildNodeByVal(String s, BasicTrieNode curNode, int i) {
		String val = s.substring(i, i+1);
		curNode = curNode.getChildNode(val);
		return curNode;
	}

	public boolean deleteWord(String s) {
		if(lookupWord(s)){
			s = s.toLowerCase();
			BasicTrieNode curNode = getRootNode();
			curNode = traverseTrieForWord(s, curNode);
			if(curNode != null && curNode.isMarkerNode()) {
				curNode.setMarkerNode(false);
				return true;
			}
		}
		return false;
	}

	public BasicTrieNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(BasicTrieNode rootNode) {
		this.rootNode = rootNode;
	}
}
