package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbersLeetcode129 {
    static class Item {
        TreeNode node;
        int num;

        public Item(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    private static int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(root, root.val));

        int sum = 0;

        while(!queue.isEmpty()) {
            Item remItem = queue.poll();

            if(remItem.node.left == null && remItem.node.right == null) {
                sum += remItem.num;
                continue;
            }

            if(remItem.node.left != null) {
                int num = remItem.num * 10 + remItem.node.left.val;
                queue.add(new Item(remItem.node.left, num));
            }

            if(remItem.node.right != null) {
                int num = remItem.num * 10 + remItem.node.right.val;
                queue.add(new Item(remItem.node.right, num));
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
