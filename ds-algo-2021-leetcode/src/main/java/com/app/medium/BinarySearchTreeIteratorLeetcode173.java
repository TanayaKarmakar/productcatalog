package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinarySearchTreeIteratorLeetcode173 {
    static class BSTIterator {
        List<TreeNode> nodes;

        public BSTIterator(TreeNode root) {
            nodes = new ArrayList<>();
            inorderTraversal(root);
        }

        public int next() {
            if(nodes.isEmpty())
                return -1;
            return nodes.remove(0).val;
        }

        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        private void inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || root != null) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                nodes.add(root);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
