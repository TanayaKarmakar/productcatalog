package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class BinaryTreeLevelOrderTraversalIILeetcode107 {
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            result.add(0, currLevel);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
