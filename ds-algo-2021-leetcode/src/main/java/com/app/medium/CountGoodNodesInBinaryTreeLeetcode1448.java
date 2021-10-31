package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 10/10/21
 * @project ds-algo-2021
 */
public class CountGoodNodesInBinaryTreeLeetcode1448 {
    private static int count = 0;
    private static int count1 = 0;

    private static void goodNodesRec(TreeNode root, TreeNode maxNode) {
        if(root == null)
            return;
        if(root.val > maxNode.val)
            maxNode = root;
        if(root.val == maxNode.val)
            count1++;
        goodNodesRec(root.left, maxNode);
        goodNodesRec(root.right, maxNode);
    }

    private static int goodNodesApproach2(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode maxNode = root;
        goodNodesRec(root, maxNode);
        return count1;
    }

    private static int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        populateMap(root, map);
        countGoodNodes(root, map);
        return count;
    }

    private static void countGoodNodes(TreeNode root, Map<TreeNode, TreeNode> map) {
        if(root == null)
            return;
        countGoodNodes(root.left, map);
        countGoodNodes(root.right, map);
        int maxVal = root.val;
        boolean isGood = true;
        TreeNode p = root;
        while(map.get(p) != null) {
            int currentVal = map.get(p).val;
            if(currentVal > maxVal) {
                isGood = false;
                break;
            }
            p = map.get(p);
        }
        if(isGood)
            count++;
    }

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


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(1);
        bt.root.right = new TreeNode(4);
        bt.root.left.left = new TreeNode(3);
        bt.root.right.left = new TreeNode(1);
        bt.root.right.right = new TreeNode(5);

        int count = goodNodes(bt.root);

        System.out.println("Approach1 - " + count);

        count = goodNodesApproach2(bt.root);

        System.out.println("Approach2 - " + count);
    }
}
