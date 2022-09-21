package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class StepByStepDirectionsInBinaryTree2096 {
    static class TreeItem {
        TreeNode node;
        String pathSoFar;

        public TreeItem(TreeNode node, String pathSoFar) {
            this.node = node;
            this.pathSoFar = pathSoFar;
        }
    }



    private static String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, Pair<TreeNode, TreeNode>> map = new HashMap<>();
        populateMap(root, null, map);
        Queue<TreeItem> queue = new LinkedList<>();
        queue.add(new TreeItem(map.get(startValue).first, ""));
        Set<Integer> visited = new HashSet<>();
        visited.add(startValue);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeItem item = queue.poll();
                if(item.node.val == destValue)
                    return item.pathSoFar;
                TreeNode node = item.node;
                if(node.left != null && !visited.contains(node.left.val)) {
                    queue.add(new TreeItem(node.left, item.pathSoFar + "L"));
                    visited.add(node.left.val);
                }

                if(node.right != null && !visited.contains(node.right.val)) {
                    queue.add(new TreeItem(node.right, item.pathSoFar + "R"));
                    visited.add(node.right.val);
                }

                Pair<TreeNode, TreeNode> pair = map.get(item.node.val);
                if(pair.second != null && !visited.contains(pair.second.val)) {
                    queue.add(new TreeItem(pair.second, item.pathSoFar + "U"));
                    visited.add(pair.second.val);
                }

            }

        }
        return "";
    }

    private static void populateMap(TreeNode root, TreeNode parent, Map<Integer, Pair<TreeNode, TreeNode>> map) {
        if(root == null)
            return;
        Pair<TreeNode, TreeNode> pair = new Pair<>(root, parent);
        map.put(root.val, pair);
        populateMap(root.left, root, map);
        populateMap(root.right, root, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        String str = getDirections(root, 3, 6);

        System.out.println(str);
    }
}
