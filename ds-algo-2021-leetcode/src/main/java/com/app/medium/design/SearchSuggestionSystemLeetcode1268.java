package com.app.medium.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 24/05/23
 * @project ds-algo-2021-leetcode
 */
public class SearchSuggestionSystemLeetcode1268 {
  static class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
      this.children = new TrieNode[26];
    }
  }

  private static void insertItems(String[] products, TrieNode root) {
    TrieNode current = root;
    for(String product: products) {
      current = root;
      for(int i = 0; i < product.length(); i++) {
        int charIndx = product.charAt(i) - 'a';
        if(current.children[charIndx] == null) {
          current.children[charIndx] = new TrieNode();
        }
        current = current.children[charIndx];
      }
      current.isEnd = true;
    }
  }

  private static void traverseList(TrieNode current, String subStr, List<String> searchResults) {
    if(searchResults.size() == 3)
      return;
    if(current.isEnd) {
      searchResults.add(subStr);
    }

    for(int charIndx = 0; charIndx < 26; charIndx++) {
      if(current.children[charIndx] != null) {
        char ch = (char)(charIndx + 'a');
        traverseList(current.children[charIndx], subStr + ch, searchResults);
      }
    }
  }

  private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = new TrieNode();
    insertItems(products, root);

    List<List<String>> result = new ArrayList<>();
    for(int i = 1; i <= searchWord.length(); i++) {
      String subStr = searchWord.substring(0, i);
      boolean isFound = true;
      TrieNode current = root;
      for(int j = 0; j < subStr.length(); j++) {
        int charIndx = subStr.charAt(j) - 'a';
        if(current.children[charIndx] == null) {
          isFound = false;
          break;
        }
        current = current.children[charIndx];
      }
      if(!isFound) {
        result.add(new ArrayList<>());
      } else {
        List<String> searchResults = new ArrayList<>();
        traverseList(current, subStr, searchResults);
        result.add(searchResults);
      }
    }
    return result;
  }



  public static void main(String[] args) {
    String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
    String searchWord = "mouse";

    List<List<String>> results = suggestedProducts(products, searchWord);

    System.out.println(results);
  }
}
