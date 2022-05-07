package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class PathInZigzagLabelledBinaryTreeLeetcode1104 {
    private static List<Integer> pathInZigZagTree(int label) {
        int height = (int)(Math.log10(label) / Math.log10(2)) + 1;
        //int totalNodes = (int)Math.pow(2, height) - 1;

        List<Integer> nodes = new ArrayList<>();

        int val = 1;
        boolean reverse = false;
        nodes.add(Integer.MAX_VALUE);
        for(int h = 1; h <= height; h++) {
            int nodesAtLevel = (int)Math.pow(2, h) - (int)Math.pow(2, h - 1);
            if(reverse) {
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i < nodesAtLevel; i++) {
                    temp.add(val++);
                }
                Collections.reverse(temp);
                nodes.addAll(temp);
            } else {
                for(int i = 0; i < nodesAtLevel; i++) {
                    nodes.add(val++);
                }
            }
            reverse = !reverse;
        }

        List<Integer> result = new ArrayList<>();
        int i = nodes.size() - 1;
        while(i >= 1 && nodes.get(i) != label) {
            i--;
        }
        result.add(label);

        while(i > 1) {
            i = i / 2;
            result.add(0, nodes.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = pathInZigZagTree(n);

        System.out.println(result);
    }
}
