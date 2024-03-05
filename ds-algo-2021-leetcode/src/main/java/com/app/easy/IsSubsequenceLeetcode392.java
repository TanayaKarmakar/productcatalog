package com.app.easy;

public class IsSubsequenceLeetcode392 {
    private static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
