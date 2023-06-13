package com.app.medium.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 10/06/23
 * @project ds-algo-2021-leetcode
 */
public class SearchSuggestionSystemsLeetcode1268 {
  static class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
      this.children = new TrieNode[26];
    }
  }

  private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    TrieNode root = new TrieNode();
    buildTrie(products, root);

    List<List<String>> result = new ArrayList<>();
    for(int i = 1; i <= searchWord.length(); i++) {
      String str = searchWord.substring(0, i);
      TrieNode current = root;
      boolean notFound = false;
      for(int j = 0; j < str.length(); j++) {
        int charIndx = str.charAt(j) - 'a';
        if(current.children[charIndx] == null) {
          notFound = true;
          break;
        }
        current = current.children[charIndx];
      }
      if(notFound) {
        result.add(new ArrayList<>());
      } else {
        List<String> currentResult = new ArrayList<>();
        traverseList(current, str, currentResult);
        result.add(currentResult);
      }
    }
    return result;
  }

  private static void traverseList(TrieNode current, String str, List<String> currentResult) {
    if(currentResult.size() == 3)
      return;
    if(current.isEnd) {
      currentResult.add(str);
    }

    for(int i = 0; i < 26; i++) {
      if(current.children[i] != null) {
        traverseList(current.children[i], str + (char)(i + 'a'), currentResult);
      }
    }
  }

  private static void buildTrie(String[] products, TrieNode root) {
    TrieNode current = root;
    for(String product: products) {
      current = root;
      for(int i = 0; i < product.length(); i++) {
        int charIndx = product.charAt(i) - 'a';
        if(current.children[charIndx] == null)
          current.children[charIndx] = new TrieNode();
        current = current.children[charIndx];
      }
      current.isEnd = true;
    }
  }


  public static void main(String[] args) {
    String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
    String searchWord = "mouse";

    List<List<String>> searchResult = suggestedProducts(products, searchWord);

    System.out.println(searchResult);
  }
}
