package com.app.medium;


import com.app.common.BinaryTree.TreeNode;

import java.util.*;

public class AmountOfTimeBinaryTreeToBeInfectedLeetcode2385 {

    private static int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        populateMaps(root, null, parentMap, nodeMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(nodeMap.get(start));
        visited.add(nodeMap.get(start));

        int count = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode remNode = queue.poll();

                if(remNode.left != null && !visited.contains(remNode.left)) {
                    queue.add(remNode.left);
                    visited.add(remNode.left);
                }

                if(remNode.right != null && !visited.contains(remNode.right)) {
                    queue.add(remNode.right);
                    visited.add(remNode.right);
                }

                TreeNode parent = parentMap.get(remNode);
                if(parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            count++;
        }
        return count;
    }

    private static void populateMaps(TreeNode node, TreeNode parent,
                                     Map<TreeNode, TreeNode> parentMap, Map<Integer, TreeNode> nodeMap) {
        if(node == null)
            return;
        parentMap.put(node, parent);
        nodeMap.put(node.val, node);
        populateMaps(node.left, node, parentMap, nodeMap);
        populateMaps(node.right, node, parentMap, nodeMap);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);


        int start = 3;
        int ans = amountOfTime(root, start);

        System.out.println(ans);
    }
}
