package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeRightSideViewLeetcode199 {
    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                if(i == size - 1) {
                    res.add(currNode.val);
                }
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
