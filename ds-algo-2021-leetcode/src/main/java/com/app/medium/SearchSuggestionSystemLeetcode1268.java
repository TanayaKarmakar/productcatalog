package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
 */
public class SearchSuggestionSystemLeetcode1268 {
  static class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
      this.children = new TrieNode[26];
    }
  }

  private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = insertProducts(products);
    List<List<String>> searchResults = new ArrayList<>();
    List<String> currentSearchResult;


    for(int i = 1; i <= searchWord.length(); i++) {
      String subStr = searchWord.substring(0, i);
      TrieNode current = root;
      boolean isFound = true;
      for(int j = 0; j < subStr.length(); j++) {
        int charIndx = subStr.charAt(j) - 'a';
        if(current.children[charIndx] == null) {
          isFound = false;
          break;
        }
        current = current.children[charIndx];
      }
      if(!isFound)
        searchResults.add(new ArrayList<>());
      else {
        currentSearchResult = new ArrayList<>();
        traverseList(current, currentSearchResult, subStr);
        searchResults.add(currentSearchResult);
      }
    }
    return searchResults;
  }

  private static void traverseList(TrieNode current, List<String> currentSearchResult, String searchStr) {
    if(currentSearchResult.size() == 3)
      return;
    if(current.isEnd) {
      currentSearchResult.add(searchStr);
    }
    for(int i = 0; i < 26; i++) {
      if(current.children[i] != null) {
        char ch = (char)(i + 'a');
        String newStr = searchStr + ch;
        traverseList(current.children[i], currentSearchResult, newStr);
      }
    }
  }

  private static TrieNode insertProducts(String[] products) {
    TrieNode root = new TrieNode();
    TrieNode current;
    for(int i = 0; i < products.length; i++) {
      String currentProduct = products[i];
      current = root;
      for(int j = 0; j < currentProduct.length(); j++) {
        int charIndx = currentProduct.charAt(j) - 'a';
        if(current.children[charIndx] == null) {
          current.children[charIndx] = new TrieNode();
        }
        current = current.children[charIndx];
      }
      current.isEnd = true;
    }
    return root;
  }


  public static void main(String[] args) {
    String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
    String searchWord = "mouse";
    List<List<String>> searchResults = suggestedProducts(products, searchWord);

    System.out.println(searchResults);
  }
}
