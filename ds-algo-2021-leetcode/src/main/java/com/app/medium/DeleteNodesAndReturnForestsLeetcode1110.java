package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForestsLeetcode1110 {
    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();

        Set<Integer> toDelSet = new HashSet<>();
        for(int del: to_delete) {
            toDelSet.add(del);
        }

        root = toDelRec(root, result, toDelSet);
        if(root != null && !toDelSet.contains(root.val)) {
           result.add(root);
        }
        return result;
    }

    private static TreeNode toDelRec(TreeNode root, List<TreeNode> result, Set<Integer> toDelSet) {
        if(root == null)
            return null;
        root.left = toDelRec(root.left, result, toDelSet);
        root.right = toDelRec(root.right, result, toDelSet);

        if(toDelSet.contains(root.val)) {
            if(root.left != null)
                result.add(root.left);
            if(root.right != null)
                result.add(root.right);
            return null;
        }
        return root;
    }


    public static void main(String[] args) {

    }
}
