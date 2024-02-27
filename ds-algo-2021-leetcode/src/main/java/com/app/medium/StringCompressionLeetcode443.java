package com.app.medium;

import java.util.Arrays;

public class StringCompressionLeetcode443 {
    private static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < chars.length;) {
            int j = i + 1;
            while(j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            int diff = (j - i);
            sb.append(chars[i]);
            if(diff > 1) {
                sb.append(diff);
            }
            i = j;
        }
        String str = sb.toString();
        chars = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            chars[i] =  str.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return str.length();

    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
    }
}
