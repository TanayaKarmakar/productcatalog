package com.app.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class ShortestWayToFormTheStringLeetcode1055 {
    private static int shortestWay(String source, String target) {
        Set<Character> sourceSet = new HashSet<>();
        Set<Character> targetSet = new HashSet<>();

        for(int i = 0; i < source.length(); i++) {
            sourceSet.add(source.charAt(i));
        }

        for(int i = 0; i < target.length(); i++) {
            if(!sourceSet.contains(target.charAt(i)))
                return -1;
            targetSet.add(target.charAt(i));
        }

        int m = source.length();
        int n = target.length();
        int i = 0;
        int j = 0;
        int count = 0;

        while(j < n) {
            if(i == m) {
                count++;
                i = 0;
            }
            if(source.charAt(i) == target.charAt(j))
                j++;
            i++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();

        int ans = shortestWay(source, target);

        System.out.println(ans);

        scanner.close();
    }
}
