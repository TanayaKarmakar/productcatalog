package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class FindLeavesInBinaryTreeLeetcode366 {
    private static List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new LinkedHashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        while(root!= null) {
            parentMap = new LinkedHashMap<>();
            populateLeaves(root, null, parentMap);
            current = new ArrayList<>();
            for(Map.Entry<TreeNode, TreeNode> entry: parentMap.entrySet()) {
                TreeNode currentLeaf = entry.getKey();
                TreeNode parent = entry.getValue();
                if(parent != null) {
                    if(parent.left == currentLeaf)
                        parent.left = null;
                    else
                        parent.right = null;
                } else {
                    root = null;
                }
                current.add(currentLeaf.val);

            }
            result.add(current);
        }
        return result;
    }

    private static void populateLeaves(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            parentMap.put(root, parent);
        }
        populateLeaves(root.left, root, parentMap);
        populateLeaves(root.right, root, parentMap);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> res = findLeaves(root);

        System.out.println(res);

    }
}
