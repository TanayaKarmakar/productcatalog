package com.app.medium;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */

class WordDictionary {
    TrieNode trieNode;

    public WordDictionary() {
        trieNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = trieNode;
        for(int i = 0; i < word.length(); i++) {

        }
    }

    public boolean search(String word) {
        return false;
    }

    static class TrieNode {
        boolean flag;
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[26];
            flag = false;
        }
    }
}


public class DesignAddAndSearchWordDataStructureLeetcode211 {
    public static void main(String[] args) {

    }
}
