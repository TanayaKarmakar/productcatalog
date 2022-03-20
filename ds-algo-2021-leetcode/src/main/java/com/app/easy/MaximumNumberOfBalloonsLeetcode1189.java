package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class MaximumNumberOfBalloonsLeetcode1189 {
    private static int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];

        for(int i = 0; i < text.length(); i++) {
            int indx = text.charAt(i) - 'a';
            chars[indx]++;
        }

        int minOcc = Integer.MAX_VALUE;
        String balloon = "balloon";
        for(int i = 0; i < balloon.length(); i++) {
            int currOcc = chars[balloon.charAt(i) - 'a'];
            if(balloon.charAt(i) == 'l' || balloon.charAt(i) == 'o')
                currOcc = currOcc / 2;
            minOcc = Integer.min(minOcc, currOcc);
        }

        return minOcc;
    }

    public static void main(String[] args) {

    }
}
