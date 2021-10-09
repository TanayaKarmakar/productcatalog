package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author t0k02w6 on 09/10/21
 * @project ds-algo-2021
 */
public class FindLeavesInBinaryTreeLeetcode366 {
    private static void populateMap(TreeNode root, Map<TreeNode, TreeNode> map) {
        if(root == null)
            return;
        if(root.left != null)
            map.put(root.left, root);
        if(root.right != null)
            map.put(root.right, root);
        populateMap(root.left, map);
        populateMap(root.right, map);
    }

    private static void trimTree(TreeNode root, Map<TreeNode, TreeNode> map, List<Integer> nodes) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode tNode = q.poll();

            boolean isLeaf = (tNode.left == null && tNode.right == null);
            if(isLeaf) {
                nodes.add(tNode.val);
                TreeNode parent = map.get(tNode);
                if(parent != null && parent.left == tNode)
                    parent.left = null;
                if(parent != null && parent.right == tNode)
                    parent.right = null;
                continue;
            }

            if(tNode.left != null)
                q.add(tNode.left);
            if(tNode.right != null)
                q.add(tNode.right);
        }
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        populateMap(root, map);
        List<List<Integer>> nodes = new ArrayList<>();

        boolean isLeaf = (root.left == null && root.right == null);
        List<Integer> layers = null;
        while(!isLeaf) {
            layers = new ArrayList<>();
            trimTree(root, map, layers);
            nodes.add(layers);
            isLeaf = (root.left == null && root.right == null);
        }
        layers = new ArrayList<>();
        layers.add(root.val);
        nodes.add(layers);

        return nodes;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new BinaryTree.TreeNode(1);
        bt.root.left = new BinaryTree.TreeNode(2);
        bt.root.right = new BinaryTree.TreeNode(3);
        bt.root.left.left = new BinaryTree.TreeNode(4);
        bt.root.left.right = new BinaryTree.TreeNode(5);

        List<List<Integer>> nodes = findLeaves(bt.root);
        System.out.println(nodes);
    }
}
