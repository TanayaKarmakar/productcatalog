package com.app.medium;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class StringCompresssionLeetcode443 {
    private static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int i = 0;
        while(i < n) {
            int j = i + 1;
            int count = 1;
            while(j < n && chars[i] == chars[j]) {
                j++;
                count++;
            }
            sb.append(chars[i] + "");
            if(count > 1)
                sb.append(count);
            i = j;
        }
        //System.out.println(sb.toString());
        int len = sb.length();
        for(i = 0; i < len; i++) {
            chars[i] = sb.charAt(i);
        }
        return len;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int ans = compress(chars);

        System.out.println(ans);

        chars = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        ans = compress(chars);

        System.out.println(ans);
    }
}
