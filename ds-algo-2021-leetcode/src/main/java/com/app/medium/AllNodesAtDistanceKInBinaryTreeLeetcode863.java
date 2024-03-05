package com.app.medium;

import java.util.*;

import com.app.common.BinaryTree.TreeNode;

public class AllNodesAtDistanceKInBinaryTreeLeetcode863 {
    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateMap(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode remNode = queue.poll();
                if(k == 0) {
                    result.add(remNode.val);
                    continue;
                }

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
            k--;
        }

        return result;
    }

    private static void populateMap(TreeNode root, TreeNode parent,
                                    Map<TreeNode, TreeNode> parentMap) {
        if(root == null)
            return;
        parentMap.put(root, parent);
        populateMap(root.left, root, parentMap);
        populateMap(root.right, root, parentMap);
    }



    public static void main(String[] args) {

    }
}
