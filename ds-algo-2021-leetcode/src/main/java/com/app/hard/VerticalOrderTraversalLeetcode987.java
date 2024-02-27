package com.app.hard;

import com.app.common.BinaryTree.TreeNode;

import java.util.*;

public class VerticalOrderTraversalLeetcode987 {
    static class QItem implements Comparable<QItem> {
        TreeNode node;
        int level;

        int pos;

        public QItem(TreeNode node, int level, int pos) {
            this.node = node;
            this.level = level;
            this.pos = pos;
        }

        @Override
        public int compareTo(QItem o) {
            if(this.level == o.level)
                return this.node.val - o.node.val;
            return this.level - o.level;
        }
    }

    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<QItem>> tMap = new TreeMap<>();
        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(root, 0, 0));

        while(!queue.isEmpty()) {
            QItem qItem = queue.poll();

            if(!tMap.containsKey(qItem.pos))
                tMap.put(qItem.pos, new ArrayList<>());
            tMap.get(qItem.pos).add(qItem);

            if(qItem.node.left != null)
                queue.add(new QItem(qItem.node.left, qItem.level + 1, qItem.pos - 1));
            if(qItem.node.right != null)
                queue.add(new QItem(qItem.node.right, qItem.level + 1, qItem.pos + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<QItem>> entry: tMap.entrySet()) {
            Collections.sort(entry.getValue());
            List<Integer> items = new ArrayList<>();
            for(QItem qItem: entry.getValue()) {
                items.add(qItem.node.val);
            }
            result.add(items);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
