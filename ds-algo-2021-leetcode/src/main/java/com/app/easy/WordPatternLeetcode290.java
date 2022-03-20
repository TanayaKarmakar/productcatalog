package com.app.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class WordPatternLeetcode290 {
    private static boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split("\\s+");
        if(sArr.length != pattern.length())
            return false;
        Map<String, String> stringStringMap = new LinkedHashMap<>();
        Map<String, String> reverseStringStringMap = new LinkedHashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            String key = pattern.charAt(i) + "";
            if(!stringStringMap.containsKey(key)) {
                stringStringMap.put(key, sArr[i]);
            } else {
                if(!sArr[i].equals(stringStringMap.get(key)))
                    return false;
            }
            if(!reverseStringStringMap.containsKey(sArr[i])) {
                reverseStringStringMap.put(sArr[i], key);
            } else {
                if(!key.equals(reverseStringStringMap.get(sArr[i])))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
