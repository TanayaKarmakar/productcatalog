package com.app.medium;

import com.app.common.BinaryTree.TreeNode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author t0k02w6 on 26/09/22
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeZigZagOrderTraversalLeetcode103 {
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        List<List<Integer>> result = new ArrayList<>();

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            while(!stack1.isEmpty()) {
                TreeNode currNode = stack1.pop();
                curr.add(currNode.val);

                if(currNode.left != null)
                    stack2.push(currNode.left);
                if(currNode.right != null)
                    stack2.push(currNode.right);
            }

            if(!curr.isEmpty())
                result.add(curr);
            curr = new ArrayList<>();
            while(!stack2.isEmpty()) {
                TreeNode currNode = stack2.pop();
                curr.add(currNode.val);

                if(currNode.right != null)
                    stack1.push(currNode.right);
                if(currNode.left != null)
                    stack1.push(currNode.left);
            }
            if(!curr.isEmpty())
                result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }
}
