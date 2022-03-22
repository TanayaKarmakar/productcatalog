package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
class VNode {
    TreeNode node;
    int pos;
    int level;

    public VNode(TreeNode node, int pos, int level) {
        this.node = node;
        this.pos = pos;
        this.level = level;
    }
}


public class BinaryTreeVerticalOrderTraversalLeetcode314 {
    private static List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<VNode> q = new LinkedList<>();
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
        q.add(new VNode(root, 0, 0));
        List<List<Integer>> list = new ArrayList<>();

        while(!q.isEmpty()) {
            VNode curr = q.poll();

            if(!tMap.containsKey(curr.pos)) {
                tMap.put(curr.pos, new ArrayList<>());
            }
            tMap.get(curr.pos).add(curr.node.val);
            if(curr.node.left != null)
                q.add(new VNode(curr.node.left, curr.pos - 1, curr.level + 1));
            if(curr.node.right != null)
                q.add(new VNode(curr.node.right, curr.pos + 1, curr.level + 1));
        }

        for(Map.Entry<Integer, List<Integer>> entry: tMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
