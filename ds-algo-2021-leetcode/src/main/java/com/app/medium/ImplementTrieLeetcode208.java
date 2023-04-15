package com.app.medium;

/**
 * @author t0k02w6 on 15/04/23
 * @project ds-algo-2021-leetcode
 */
public class ImplementTrieLeetcode208 {
  static class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.isEnd = false;
    }
  }

  static class Trie {
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


  public static void main(String[] args) {

  }
}
