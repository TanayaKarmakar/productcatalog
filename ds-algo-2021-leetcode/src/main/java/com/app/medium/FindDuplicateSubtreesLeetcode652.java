package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtreesLeetcode652 {
    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        findDuplicateSubtreesRec(root, result, map);
        return result;
    }

    private static String findDuplicateSubtreesRec(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if(root == null)
            return "";
        String leftStr = findDuplicateSubtreesRec(root.left, result, map);
        String rightStr = findDuplicateSubtreesRec(root.right, result, map);
        StringBuilder sb = new StringBuilder();
        sb.append(leftStr).append("#");
        sb.append(rightStr).append("#");
        sb.append(root.val);
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if(map.get(key) == 2) {
            result.add(root);
        }
        return key;
    }

    public static void main(String[] args) {

    }
}
