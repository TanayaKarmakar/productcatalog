package com.app.medium.design;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */


class WordDictionary {
  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode current = root;
    for(int i = 0; i < word.length(); i++) {
      int indx = word.charAt(i) - 'a';
      if(current.nodes[indx] == null)
        current.nodes[indx] = new TrieNode();
      current = current.nodes[indx];
    }
    current.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    return searchRec(word, 0, current);
  }

  private boolean searchRec(String word, int indx, TrieNode current) {
    if(indx >= word.length())
      return current.isEnd;
    char ch = word.charAt(indx);
    if(ch == '.') {
      for(int i = 0; i < 26; i++) {
        if(current.nodes[i] != null) {
          boolean isFound = searchRec(word, indx + 1, current.nodes[i]);
          if(isFound)
            return true;
        }
      }
    } else {
      int charIndx = ch - 'a';
      if(current.nodes[charIndx] == null)
        return false;
      return searchRec(word, indx + 1, current.nodes[charIndx]);
    }
    return false;
  }


  static class TrieNode {
    TrieNode[] nodes;
    boolean isEnd;

    public TrieNode() {
      nodes = new TrieNode[26];
    }
  }
}

public class DesignAddAndSearchDataStructureLeetcode211 {
  public static void main(String[] args) {
    WordDictionary wd = new WordDictionary();
    wd.addWord("bad");
    wd.addWord("dad");
    wd.addWord("mad");
    System.out.println(wd.search("pad")); // return False
    System.out.println(wd.search("bad")); // return True
    System.out.println(wd.search(".ad")); // return True
    System.out.println(wd.search("b.."));
  }
}
