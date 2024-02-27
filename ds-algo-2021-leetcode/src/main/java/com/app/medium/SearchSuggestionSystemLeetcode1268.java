package com.app.medium;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystemLeetcode1268 {
    static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        insertProducts(products, root);

        List<List<String>> result = new ArrayList<>();
        searchProducts(root, searchWord, result);
        return result;
    }

    private static void searchProducts(TrieNode root, String searchWord, List<List<String>> result) {
        for(int i = 1; i <= searchWord.length(); i++) {
            String currentTerm = searchWord.substring(0, i);
            TrieNode current = root;
            boolean notFound = false;
            for(int j = 0; j < currentTerm.length(); j++) {
                int charIndx = currentTerm.charAt(j) - 'a';
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
                searchProductsHelper(current, currentTerm, currentResult);
                result.add(currentResult);
            }
        }
    }

    private static void searchProductsHelper(TrieNode current, String currentTerm, List<String> currentResult) {
        if(currentResult.size() == 3) {
            return;
        }
        if(current.isEnd) {
            currentResult.add(currentTerm);
        }

        for(int i = 0; i < 26; i++) {
            if(current.children[i] != null) {
                char ch = (char)(i + 'a');
                searchProductsHelper(current.children[i], currentTerm + ch, currentResult);
            }
        }
    }


    private static void insertProducts(String[] products, TrieNode root) {
        for(String product: products) {
            insertProduct(product, root);
        }
    }

    private static void insertProduct(String product, TrieNode root) {
        TrieNode current = root;
        for(int i = 0; i < product.length(); i++) {
            int charIndx = product.charAt(i) - 'a';
            if(current.children[charIndx] == null) {
                current.children[charIndx] = new TrieNode();
            }
            current = current.children[charIndx];
        }
        current.isEnd = true;
    }


    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = suggestedProducts(products, searchWord);

        System.out.println(result);

        products = new String[] {"havana"};
        searchWord = "havana";
        result = suggestedProducts(products, searchWord);
        System.out.println(result);
    }
}
