package com.app.easy;

import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTreesLeetcode872 {
    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        List<TreeNode> tree1List = new ArrayList<>();
        List<TreeNode> tree2List = new ArrayList<>();
        populateLeaves(root1, tree1List);
        populateLeaves(root2, tree2List);

        if(tree1List.size() != tree2List.size())
            return false;
        for(int i = 0; i < tree1List.size(); i++) {
            if(tree1List.get(i).val != tree2List.get(i).val)
                return false;
        }
        return true;
    }

    private static void populateLeaves(TreeNode root, List<TreeNode> treeNodes) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            treeNodes.add(root);
        }
        populateLeaves(root.left, treeNodes);
        populateLeaves(root.right, treeNodes);
    }


    public static void main(String[] args) {

    }
}
