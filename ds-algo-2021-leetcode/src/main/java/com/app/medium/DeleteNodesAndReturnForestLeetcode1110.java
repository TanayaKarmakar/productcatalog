package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class DeleteNodesAndReturnForestLeetcode1110 {
    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int el: to_delete) {
            set.add(el);
        }

        List<TreeNode> result = new ArrayList<>();
        delNodesRec(root, set, result);

        if(!set.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private static TreeNode delNodesRec(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if(root == null)
            return null;
        root.left = delNodesRec(root.left, set, result);
        root.right = delNodesRec(root.right, set, result);

        if(set.contains(root.val)) {
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
