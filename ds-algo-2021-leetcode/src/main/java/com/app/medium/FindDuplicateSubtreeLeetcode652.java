package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class FindDuplicateSubtreeLeetcode652 {
    private static String duplicateRec(TreeNode root, Map<String, Pair<TreeNode, Integer>> map, List<TreeNode> result) {
        if(root == null)
            return "";
        String leftStr = duplicateRec(root.left, map, result);
        String rightStr = duplicateRec(root.right, map, result);

        StringBuilder sb = new StringBuilder();

        sb.append(leftStr).append("#");
        sb.append(rightStr).append("#");
        sb.append(root.val);
        String key = sb.toString();
        Pair<TreeNode, Integer> pair = null;
        if(!map.containsKey(key)) {
            pair = new Pair<>(root, 1);
        } else {
            pair = map.get(key);
            pair.second += 1;
            if(pair.second == 2)
                result.add(root);
        }
        map.put(key, pair);
        return key;
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        duplicateRec(root, map, result);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(2);
        bt.root.right.right = new TreeNode(4);
        bt.root.right.left.left = new TreeNode(4);

        List<TreeNode> result = findDuplicateSubtrees(bt.root);

        System.out.println(result.size());
    }
}
