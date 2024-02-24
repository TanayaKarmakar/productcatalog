package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversalLeetcode314 {
    static class TreeItem {
        TreeNode node;
        int currentVal;

        public TreeItem(TreeNode node, int currentVal) {
            this.node = node;
            this.currentVal = currentVal;
        }
    }

    private static List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        populateMap(root, map);

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static void populateMap(TreeNode root, TreeMap<Integer, List<Integer>> map) {
        if(root == null)
            return;
        Queue<TreeItem> q = new LinkedList<>();
        q.add(new TreeItem(root, 0));

        while(!q.isEmpty()) {
            TreeItem item = q.poll();
            int currentVal = item.currentVal;
            if(!map.containsKey(currentVal)) {
                map.put(currentVal, new ArrayList<>());
            }
            map.get(currentVal).add(item.node.val);

            if(item.node.left != null) {
                q.add(new TreeItem(item.node.left, currentVal - 1));
            }
            if(item.node.right != null) {
                q.add(new TreeItem(item.node.right, currentVal + 1));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalOrder(root);

        System.out.println(result);
    }
}
