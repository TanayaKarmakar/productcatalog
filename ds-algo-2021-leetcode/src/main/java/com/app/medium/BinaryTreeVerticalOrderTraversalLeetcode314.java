package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 18/09/22
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeVerticalOrderTraversalLeetcode314 {
    static class TreeItem {
        TreeNode node;
        int level;

        public TreeItem(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        //populateTree(root, 0, map);

        Queue<TreeItem> q = new LinkedList<>();
        q.add(new TreeItem(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeItem item = q.poll();
                int level = item.level;
                if(!map.containsKey(level)) {
                    map.put(level, new ArrayList<>());
                }
                map.get(level).add(item.node.val);

                if(item.node.left != null) {
                    q.add(new TreeItem(item.node.left, level - 1));
                }
                if(item.node.right != null) {
                    q.add(new TreeItem(item.node.right, level + 1));
                }
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
