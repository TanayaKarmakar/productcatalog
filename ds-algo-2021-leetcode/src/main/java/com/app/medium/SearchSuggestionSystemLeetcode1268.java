package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class SearchSuggestionSystemLeetcode1268 {
    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        String currentSearchStr = "";
        for(int i = 0; i < searchWord.length(); i++) {
            List<String> currentResult = new ArrayList<>();
            currentSearchStr = currentSearchStr + searchWord.charAt(i);
            for(String product: products) {
                if(product.startsWith(currentSearchStr)) {
                    currentResult.add(product);
                }
            }
            if (currentResult.size() > 3) {
                currentResult = currentResult.subList(0, 3);
            }
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        List<List<String>> result = suggestedProducts(str, searchWord);

        System.out.println(result);
    }
}
