package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
class BSTIterator {
    List<Integer> result;
    int indx;

    public BSTIterator(TreeNode root) {
        result = new ArrayList<>();
        indx = 0;
        inorder(root);
    }

    public int next() {
        int val = result.get(indx);
        indx++;
        return val;
    }

    public boolean hasNext() {
        return indx < result.size();
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}


public class BinarySearchTreeIteratorLeetcode173 {
    public static void main(String[] args) {

    }
}
