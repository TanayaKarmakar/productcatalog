package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
public class FindLeavesOfBinaryTreeLeetcode366 {
    private static void populateMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if(root == null)
            return;
        map.put(root, parent);
        populateMap(root.left, root, map);
        populateMap(root.right, root, map);
    }

    private static void getLeaves(TreeNode root, List<TreeNode> list) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            list.add(root);
        }
        getLeaves(root.left, list);
        getLeaves(root.right, list);
    }

    private static List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        populateMap(root, null, map);

        while(root.left != null || root.right != null) {
            List<TreeNode> currentLeaves = new ArrayList<>();
            List<Integer> currentLeavesValues = new ArrayList<>();
            getLeaves(root, currentLeaves);
            for(TreeNode currentLeave: currentLeaves) {
                TreeNode parent = map.get(currentLeave);
                if(parent != null) {
                    if(parent.left == currentLeave)
                        parent.left = null;
                    if(parent.right == currentLeave)
                        parent.right = null;
                }
                currentLeavesValues.add(currentLeave.val);
            }
            result.add(currentLeavesValues);
        }
        List<Integer> currentLeavesValues = new ArrayList<>();
        currentLeavesValues.add(root.val);
        result.add(currentLeavesValues);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        List<List<Integer>> list = findLeaves(bt.root);

        System.out.println(list);
    }
}
