package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.common.BinaryTree.TreeNode;

public class FindLeavesOfBinaryTreeLeetcode366 {
    private static List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        while(root != null) {
            nodeMap.clear();
            populateMap(root, null, nodeMap);
            List<Integer> currentResult = new ArrayList<>();
            for(Map.Entry<TreeNode, TreeNode> entry: nodeMap.entrySet()) {
                TreeNode leafNode = entry.getKey();
                TreeNode parentNode = entry.getValue();
                if(parentNode != null) {
                    if(parentNode.left == leafNode)
                        parentNode.left = null;
                    else if(parentNode.right == leafNode)
                        parentNode.right = null;
                } else {
                    root = null;
                }

                currentResult.add(leafNode.val);
            }
            result.add(currentResult);
        }
        return result;
    }

    private static void populateMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeMap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            nodeMap.put(root, parent);
        populateMap(root.left, root, nodeMap);
        populateMap(root.right, root, nodeMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = findLeaves(root);

        System.out.println(result);
    }
}
