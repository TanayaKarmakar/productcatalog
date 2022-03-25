package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
public class GroupAnagramLeetcode49 {
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            int[] count = new int[26];
            for(char ch: arr) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> values = groupAnagrams(str);

        System.out.println(values);
    }
}
