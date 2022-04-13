package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 12/04/22
 * @project ds-algo-2021
 */
public class CloneGraphLeetcode133 {
    public static Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(node.neighbors.size() == 0)
            return new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs1(node, visited, map);
        visited.clear();
        dfs2(node, visited, map);
        return map.get(node.val);
    }

    private static void dfs2(Node node, Set<Integer> visited, Map<Integer, Node> nodeMap) {
        Node newNode = nodeMap.get(node.val);
        visited.add(node.val);
        List<Node> neighbors = node.neighbors;
        for(Node nei: neighbors) {
            Node newNeiNode = nodeMap.get(nei.val);
            newNode.neighbors.add(newNeiNode);
        }

        for(Node nei: neighbors) {
            if(!visited.contains(nei.val)) {
                //newNeiNode.neighbors.add(newNode);
                dfs2(nei, visited, nodeMap);
            }
        }
    }

    private static void dfs1(Node node, Set<Integer> visited, Map<Integer, Node> nodeMap) {
        Node newNode = new Node(node.val);
        visited.add(node.val);
        nodeMap.put(node.val, newNode);
        List<Node> neibhbors = node.neighbors;
        for(Node nei: neibhbors) {
            if(!visited.contains(nei.val)) {
                dfs1(nei, visited, nodeMap);
            }
        }
    }

    public static void main(String[] args) {

    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
