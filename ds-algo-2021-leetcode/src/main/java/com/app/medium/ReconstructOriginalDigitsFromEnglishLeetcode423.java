package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 02/10/21
 * @project ds-algo-2021
 */

//0 --- zero
//        1 --- one
//        2 --- two
//        3 --- three
//        4 --- four
//        5 --- five
//        6 --- six
//        7 --- seven
//        8 --- eight
//        9 --- nine
//
//
//
//        z -- 0
//        w -- 2
//        u -- 4
//        x -- 6
//        g -- 8
//
//
//        h -- 3, 8
//        f -- 5, 4
//        s -- 7, 6
//
//
//        i -- 5, 6, 8, 9
//        n -- 9, 9, 7, 1
public class ReconstructOriginalDigitsFromEnglishLeetcode423 {

    private static String originalDigits(String s) {
       int[] count = new int[26];
       for(char ch: s.toCharArray()) {
           count[ch - 'a']++;
       }

       int[] digit = new int[10];
       digit[0] = count['z' - 'a'];
       digit[2] = count['w' - 'a'];
       digit[4] = count['u' - 'a'];
       digit[6] = count['x' - 'a'];
       digit[8] = count['g' - 'a'];

       digit[3] = count['h' - 'a'] - digit[8];
       digit[5] = count['f' - 'a'] - digit[4];
       digit[7] = count['s' - 'a'] - digit[6];

       digit[9] = count['i' - 'a'] - digit[5] - digit[6] - digit[8];
       digit[1] = count['n' - 'a'] - digit[7] - 2 * digit[9];

       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < 10; i++) {
           for(int j = 0; j < digit[i]; j++)
               sb.append(i + "");
       }

       return sb.toString();
    }

    public static void main(String[] args) {
        String s = "fviefuro";
        String ans = originalDigits(s);

        System.out.println(ans);
    }
}
