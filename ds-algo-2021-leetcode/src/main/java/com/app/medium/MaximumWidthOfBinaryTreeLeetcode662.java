package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTreeLeetcode662 {
    static class TreeItem {
        TreeNode node;
        int pos;
        public TreeItem(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    private static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeItem> queue = new LinkedList<>();
        queue.add(new TreeItem(root, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            int start = -1;
            int end = -1;
            for(int i = 0; i < size; i++) {
                TreeItem remItem = queue.poll();
                if(i == 0) {
                    start = remItem.pos;
                }

                if(i == size - 1) {
                    end = remItem.pos;
                }
                if(remItem.node.left != null) {
                    queue.add(new TreeItem(remItem.node.left, 2 * remItem.pos + 1));
                }

                if(remItem.node.right != null) {
                    queue.add(new TreeItem(remItem.node.right, 2 * remItem.pos + 2));
                }
            }
            maxWidth = Integer.max(maxWidth, (end - start + 1));
        }

        return maxWidth;
    }

    public static void main(String[] args) {

    }
}
