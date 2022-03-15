package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 15/03/22
 * @project ds-algo-2021
 */
public class MinimumDepthLeetcode111 {
    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int count = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode rem = q.poll();
                if(isLeaf(rem))
                    return count;
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
