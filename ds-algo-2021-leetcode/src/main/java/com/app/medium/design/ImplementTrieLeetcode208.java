package com.app.medium.design;

class Trie {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int chIndx = word.charAt(i) - 'a';
            if(current.children[chIndx] == null) {
                current.children[chIndx] = new TrieNode();
            }
            current = current.children[chIndx];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int chIndx = word.charAt(i) - 'a';
            if(current.children[chIndx] == null) {
                return false;
            }
            current = current.children[chIndx];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            int chIndx = prefix.charAt(i) - 'a';
            if(current.children[chIndx] == null) {
                return false;
            }
            current = current.children[chIndx];
        }
        return true;
    }
}

public class ImplementTrieLeetcode208 {
    public static void main(String[] args) {

    }
}
