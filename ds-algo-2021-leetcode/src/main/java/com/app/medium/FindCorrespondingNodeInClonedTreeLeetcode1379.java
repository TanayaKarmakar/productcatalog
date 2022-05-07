package com.app.medium;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class FindCorrespondingNodeInClonedTreeLeetcode1379 {
    private static TreeNode clonedRes = null;

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)
            return null;
        getTargetCopyRec(original, cloned, target);
        return clonedRes;
    }

    private static void getTargetCopyRec(TreeNode original, TreeNode cloned, TreeNode target) {
        if(original == null)
            return;
        if(original == target) {
            clonedRes = cloned;
            return;
        }
        getTargetCopyRec(original.left, cloned.left, target);
        getTargetCopyRec(original.right, cloned.right, target);
    }

    public static void main(String[] args) {

    }
}
