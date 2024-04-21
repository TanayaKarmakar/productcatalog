package com.app.medium.salesforce;

import com.app.common.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SmallestSubtreeWithDeepestNodesLeetcode865 {
    static class TreeItem {
        TreeNode node;
        int currDepth;

        public TreeItem(TreeNode node, int currDepth) {
            this.node = node;
            this.currDepth = currDepth;
        }
    }

    private static int maxDepth = 0;
    private static TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        maxDepth = 0;
        populateDepthMap(root, depthMap);
        return getSmallestSubtree(root, depthMap);
    }

    private static TreeNode getSmallestSubtree(TreeNode root, Map<TreeNode, Integer> depthMap) {
        if(root == null || depthMap.get(root) == maxDepth)
            return root;
        TreeNode left = getSmallestSubtree(root.left, depthMap);
        TreeNode right = getSmallestSubtree(root.right, depthMap);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }


    private static void populateDepthMap(TreeNode root, Map<TreeNode, Integer> depthMap) {
        Queue<TreeItem> queue = new LinkedList<>();
        queue.add(new TreeItem(root,1 ));

        while(!queue.isEmpty()) {
            TreeItem remItem = queue.poll();
            depthMap.put(remItem.node, remItem.currDepth);
            maxDepth = Integer.max(maxDepth, remItem.currDepth);

            if(remItem.node.left != null) {
                queue.add(new TreeItem(remItem.node.left, remItem.currDepth + 1));
            }
            if(remItem.node.right != null) {
                queue.add(new TreeItem(remItem.node.right, remItem.currDepth + 1));
            }
        }
    }

    private static void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode ans = subtreeWithAllDeepest(root);
        printTree(ans);

    }
}
