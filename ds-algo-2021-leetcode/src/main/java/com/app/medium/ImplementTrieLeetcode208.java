package com.app.medium;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */

class Trie {
  static class TrieNode208 {
    boolean isEnd;
    TrieNode208[] children;

    public TrieNode208() {
      this.children = new TrieNode208[26];
    }
  }

  private TrieNode208 root;

  public Trie() {
    root = new TrieNode208();
  }

  public void insert(String word) {
    TrieNode208 current = root;
    for(int i = 0; i < word.length(); i++) {
      int indx = word.charAt(i) - 'a';
      if(current.children[indx] == null) {
        current.children[indx] = new TrieNode208();
      }
      current = current.children[indx];
    }
    current.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode208 current = root;
    for(int i = 0; i < word.length(); i++) {
      int indx = word.charAt(i) - 'a';
      if(current.children[indx] == null)
        return false;
      current = current.children[indx];
    }
    return current.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode208 current = root;
    for(int i = 0; i < prefix.length(); i++) {
      int indx = prefix.charAt(i) - 'a';
      if(current.children[indx] == null)
        return false;
      current = current.children[indx];
    }
    return true;
  }
}

public class ImplementTrieLeetcode208 {




  public static void main(String[] args) {

  }
}
