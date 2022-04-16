package com.app.medium;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
class TrieNode {
    TrieNode[] nodes;
    boolean flag;

    public TrieNode() {
        nodes = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.nodes[ch - 'a'] == null)
                curr.nodes[ch - 'a'] = new TrieNode();
            curr = curr.nodes[ch - 'a'];
        }

        curr.flag = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.nodes[ch - 'a'] == null)
                return false;
            curr = curr.nodes[ch - 'a'];
        }
        return curr.flag;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.nodes[ch - 'a'] == null)
                return false;
            curr = curr.nodes[ch - 'a'];
        }
        return curr != null;
    }
}



public class ImplementTrieLeetcode208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
