package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
public class BinaryTreeRightSideViewLeetcode199 {
    private static List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == size - 1)
                    result.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
