package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class BinaryTreeLevelOrderZigzagTraversalLeetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);
        List<Integer> item = new ArrayList<>();

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            item = new ArrayList<>();
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                item.add(node.val);

                if(node.left != null)
                    stack2.push(node.left);
                if(node.right != null)
                    stack2.push(node.right);
            }

            if(!item.isEmpty())
                list.add(item);

            item = new ArrayList<>();
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                item.add(node.val);

                if(node.right != null)
                    stack1.push(node.right);
                if(node.left != null)
                    stack1.push(node.left);
            }
            if(!item.isEmpty())
                list.add(item);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
