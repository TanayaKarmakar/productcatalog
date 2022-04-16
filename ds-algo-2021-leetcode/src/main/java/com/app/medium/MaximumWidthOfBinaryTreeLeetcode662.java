package com.app.medium;


import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class MaximumWidthOfBinaryTreeLeetcode662 {
    private static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int ans = 0;
        int first = 0;
        int last = 0;
        int minLevel = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            minLevel = q.peek().second;
            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> remNode = q.poll();
                int currLevel = remNode.second - minLevel;
                if(i == 0)
                    first = remNode.second;
                if(i == size - 1)
                    last = remNode.second;
                if(remNode.first.left != null) {
                    Pair<TreeNode, Integer> pair = new Pair<>(remNode.first.left, 2 * currLevel + 1);
                    q.add(pair);
                }
                if(remNode.first.right != null) {
                    Pair<TreeNode, Integer> pair = new Pair<>(remNode.first.right, 2 * currLevel + 2);
                    q.add(pair);
                }
            }
            ans = Integer.max(ans, (last - first + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(2);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(3);
        bt.root.right.right = new TreeNode(9);

        int ans = widthOfBinaryTree(bt.root);

        System.out.println(ans);
    }
}
