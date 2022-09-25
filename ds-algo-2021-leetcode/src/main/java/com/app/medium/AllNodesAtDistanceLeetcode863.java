package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class AllNodesAtDistanceLeetcode863 {
    
    
    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateMap(root, null, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while(!q.isEmpty() && k > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();
                if(currentNode.left != null && !visited.contains(currentNode.left)) {
                    q.add(currentNode.left);
                    visited.add(currentNode.left);
                }

                if(currentNode.right != null && !visited.contains(currentNode.right)) {
                    q.add(currentNode.right);
                    visited.add(currentNode.right);
                }
                TreeNode parentNode = parentMap.get(currentNode);
                if(parentNode != null && !visited.contains(parentNode)) {
                    q.add(parentNode);
                    visited.add(parentNode);
                }
            }
            k--;
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode currentNode = q.poll();
            result.add(currentNode.val);
        }
        return result;
    }

    private static void populateMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(root == null)
            return;
        parentMap.put(root, parent);
        populateMap(root.left, root, parentMap);
        populateMap(root.right, root, parentMap);
    }


    public static void main(String[] args) {

    }
}
