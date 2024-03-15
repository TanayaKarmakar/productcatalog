package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.common.BinaryTree.TreeNode;

public class BinaryTreeLevelOrderTraversalLeetcode102 {
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentResult = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode remNode = queue.poll();
                currentResult.add(remNode.val);
                if(remNode.left != null)
                    queue.add(remNode.left);
                if(remNode.right != null)
                    queue.add(remNode.right);
            }
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
