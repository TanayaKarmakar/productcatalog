package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class SearchSuggestionSystemLeetcode1268 {
    private static TrieNode buildTrie(String[] products) {
        TrieNode node = new TrieNode();
        for(String product: products) {
            TrieNode current = node;
            for(int i = 0; i < product.length(); i++) {
                int charIndx = product.charAt(i) - 'a';
                if(current.nodes[charIndx] == null) {
                    current.nodes[charIndx] = new TrieNode();
                }
                current = current.nodes[charIndx];
            }
            current.flag = true;
        }
        return node;
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode trieNode = buildTrie(products);
        List<List<String>> result = new ArrayList<>();

        for(int i = 1; i <= searchWord.length(); i++) {
            String current = searchWord.substring(0, i);
            TrieNode node = trieNode;
            boolean isFound = true;
            for(int j = 0; j < current.length(); j++) {
                int charIndx = current.charAt(j) - 'a';
                if(node.nodes[charIndx] == null) {
                    isFound = false;
                    break;
                }
                node = node.nodes[charIndx];
            }
            if(!isFound) {
                result.add(new ArrayList<>());
            } else {
                List<String> items = new ArrayList<>();
                traverseList(node, current, items);
                result.add(items);
            }
        }
        return result;
    }

    private static void traverseList(TrieNode node, String current, List<String> items) {
        if(items.size() == 3)
            return;
        if(node.flag) {
            items.add(current);
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(node.nodes[i] != null) {
                char ch = (char)(i + 'a');
                traverseList(node.nodes[i], current + ch, items);
            }
        }
    }

    public static void main(String[] args) {

    }
}
