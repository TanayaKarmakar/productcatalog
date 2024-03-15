package com.app.medium;

import java.util.*;

public class CloneGraphLeetcode133 {
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

    private static Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        populateMap(node, nodeMap, visited);
        visited.clear();
        connectLink(node, nodeMap, visited);
        return nodeMap.get(node);
    }

    private static void connectLink(Node node, Map<Node, Node> map, Set<Integer> visited) {
        List<Node> neighbors = node.neighbors;
        visited.add(node.val);
        if(!neighbors.isEmpty()) {
            for(Node nei: neighbors) {
                map.get(node).neighbors.add(map.get(nei));
            }

            for(Node nei: neighbors) {
                if(!visited.contains(nei.val)) {
                    connectLink(nei, map, visited);
                }
            }
        }
    }

    private static void populateMap(Node node, Map<Node, Node> map, Set<Integer> visited) {
        map.put(node, new Node(node.val));
        visited.add(node.val);

        List<Node> neighbors = node.neighbors;
        if(!neighbors.isEmpty()) {
            for(Node nei: neighbors) {
                if(!visited.contains(nei.val)) {
                    populateMap(nei, map, visited);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
