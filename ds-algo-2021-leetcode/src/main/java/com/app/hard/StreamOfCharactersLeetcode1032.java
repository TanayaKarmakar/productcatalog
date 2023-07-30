package com.app.hard;

/**
 * @author t0k02w6 on 27/07/23
 * @project ds-algo-2021-leetcode
 */

class StreamChecker {
  static class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
      this.children = new TrieNode[26];
    }
  }

  TrieNode root;
  StringBuilder sb;

  public StreamChecker(String[] words) {
    root = new TrieNode();
    sb = new StringBuilder();
    insertWords(words);
  }

  public boolean query(char letter) {
    sb.append(letter);
    TrieNode current = root;
    for(int i = sb.length() - 1; i >= 0; i--) {
      int charIndx = sb.charAt(i) - 'a';
      if(current.children[charIndx] == null)
        return false;
      if(current.children[charIndx].isEnd)
        return true;
      current = current.children[charIndx];
    }
    return false;
  }

  private void insertWords(String[] words) {
    for(String word: words) {
      insertWord(word);
    }
  }

  private void insertWord(String word) {
    TrieNode current = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      int indx = word.charAt(i) - 'a';
      if (current.children[indx] == null) {
        current.children[indx] = new TrieNode();
      }
      current = current.children[indx];
    }
    current.isEnd = true;
  }
}

public class StreamOfCharactersLeetcode1032 {
  public static void main(String[] args) {
    StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
    System.out.println(streamChecker.query('a')); // return False
    System.out.println(streamChecker.query('b')); // return False
    System.out.println(streamChecker.query('c')); // return False
    System.out.println(streamChecker.query('d')); // return True, because 'cd' is in the wordlist
    streamChecker.query('e'); // return False
    streamChecker.query('f'); // return True, because 'f' is in the wordlist
    streamChecker.query('g'); // return False
    streamChecker.query('h'); // return False
    streamChecker.query('i'); // return False
    streamChecker.query('j'); // return False
    streamChecker.query('k'); // return False
    streamChecker.query('l'); // return True, because 'kl' is in the wordlist
  }

}
