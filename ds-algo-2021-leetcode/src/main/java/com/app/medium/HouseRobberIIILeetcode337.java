package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class HouseRobberIIILeetcode337 {
    static Map<TreeNode, Integer> robMap = new HashMap<>();
    static Map<TreeNode, Integer> notRobMap = new HashMap<>();

    private static int robRec(TreeNode root, boolean rob) {
        if(root == null)
            return 0;
        if(rob) {
            if(!robMap.containsKey(root)) {
                int value = root.val + robRec(root.left, !rob) + robRec(root.right, !rob);
                robMap.put(root, value);
            }
            return robMap.get(root);
        } else {
            if(!notRobMap.containsKey(root)) {
                int option1 = Integer.max(robRec(root.left, rob), robRec(root.left, !rob));
                int option2 = Integer.max(robRec(root.right, rob), robRec(root.right, !rob));
                notRobMap.put(root, option1 + option2);
            }
            return notRobMap.get(root);
        }
    }

    private static int rob(TreeNode root) {
        int option1 = robRec(root, true);
        int option2 = robRec(root, false);
        return Integer.max(option1, option2);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.right = new TreeNode(3);
        bt.root.right.right = new TreeNode(1);

        int ans = rob(bt.root);

        System.out.println(ans);
    }
}
