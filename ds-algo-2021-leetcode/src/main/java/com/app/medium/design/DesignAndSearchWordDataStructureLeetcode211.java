package com.app.medium.design;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class DesignAndSearchWordDataStructureLeetcode211 {
  static class WordDictionary {
    static class TrieNode {
      boolean isEnd;
      TrieNode[] children;

      public TrieNode() {
        this.children = new TrieNode[26];
      }
    }

    TrieNode root;

    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode current = root;
      for(int i = 0; i < word.length(); i++) {
        int charIndx = word.charAt(i) - 'a';
        if(current.children[charIndx] == null) {
          current.children[charIndx] = new TrieNode();
        }
        current = current.children[charIndx];
      }
      current.isEnd = true;
    }

    public boolean search(String word) {
      TrieNode current = root;
      return searchRec(word, current, 0);
    }

    private boolean searchRec(String word, TrieNode current, int indx) {
      if(indx == word.length())
        return current.isEnd;
      char ch = word.charAt(indx);
      if(ch == '.') {
        for(int i = 0; i < 26; i++) {
          if(current.children[i] != null) {
            if(searchRec(word, current.children[i], indx + 1))
              return true;
          }
        }
      } else {
        int charIndx = ch - 'a';
        if(current.children[charIndx] == null)
          return false;
        return searchRec(word, current.children[charIndx], indx + 1);
      }
      return false;
    }
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    System.out.println(wordDictionary.search("pad"));
    System.out.println(wordDictionary.search("bad"));
    System.out.println(wordDictionary.search(".ad"));
    System.out.println(wordDictionary.search("b.."));
  }
}
