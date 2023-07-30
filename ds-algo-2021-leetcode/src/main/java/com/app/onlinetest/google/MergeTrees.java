package com.app.onlinetest.google;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**Design and implement the following method to merge two document trees t1 and t2, according to the merging rules specified below.

    Document trees consist of nodes represented by the Node class defined below. Trees can be arbitrarily deep and each node can have arbitrarily many child nodes. Child nodes are order sensitive,
    and there can be multiple sibling child nodes with the same name property.

 * Represents a node in a document tree. Assume that this class also provides
 * reasonable implementations of constructors, builders, getters, setters,
 * hashCode(), equals(), etc.
 *
 * Tip: To keep things simple, consider treating this as a deeply immutable
 * class.


class Node {

  String name //name of the node


  String value; // value of the node
  List<Node> childNodes; // child nodes of the node
}

  Merging Rules
  Guiding principle:
    Use t1's node ordering, but t2's node values.
    When node n1 from t1 is merged with node n2 from t2, the following rules are applied to derive the merged node m (see merging example below):
    The merged node m will take the value property of n2.
    The k-th child node of n1 with the name X will be matched and merged with the k-th child node of n2 with the same name X.
    The merged node m will contain all the child nodes of n1 in the same order, but they may have different value properties and child nodes depending on whether they have been merged with the child nodes of
    n2.
    Unmatched child nodes of n1 will be left unchanged in the merged node m.
    Unmatched child nodes of n2 will be added unchanged to the merged node m after the child nodes of n1.

    Merging Example


    INPUT: t1
    ROOT: valueT1 (m)
    A: alpha
      C: beta
      X: phix
        Z: mu
    B: gamma
    A: delta
    C: epsilon
    D: theta


    INPUT: t2 (n)
    ROOT: valueT2
    C: zeta
    E: kappa
      W: eta
    B: lambda
    A: tau                node1
      Y: pi
      C: sigma
    A: omicron
    B: omega


    OUTPUT: merge(t1, t2)
    ROOT: valueT2 ............. value from t2
    A: tau ........... value from t2
      C: sigma ..... value from t2
      X: phix ....... unmatched node from t1
        Z: mu .... child node of the unmatched X node from t1
      Y: pi ........ unmatched node from t2
    B: lambda ........ value from t2
    A: omicron ....... value from t2 (second A node from t1 and t2)
    C: zeta .......... value from t2
    D: theta ......... unmatched node from t1
    E: kappa ......... unmatched node from t2
      W: eta ....... child node of the unmatched E node from t2
    B: omega ......... unmatched node from t2
**/

public class MergeTrees {
  static class Node {
    String name;
    String value;
    List<Node> childNodes;
  }

  static class NodeItem {
    Node currentNode;
    List<Node> t1Children;
    List<Node> t2Children;

    public NodeItem(Node currentNode, List<Node> t1Children, List<Node> t2Children) {
      this.currentNode = currentNode;
      this.t1Children = t1Children;
      this.t2Children = t2Children;
    }
  }

  static class NodePair {
    Node firstNode;
    Node secondNode;

    public NodePair(Node firstNode, Node secondNode) {
      this.firstNode = firstNode;
      this.secondNode = secondNode;
    }
  }

  private static Node resultRoot;

  private static Node solve(Node t1, Node t2) {
    resultRoot = null;
    Queue<NodeItem> q = new LinkedList<>();
    Node newNode = new Node();
    newNode.name = t1.name;
    newNode.value = t2.value;
    resultRoot = newNode;
    q.add(new NodeItem(newNode, t1.childNodes, t2.childNodes));

    Map<Node, NodeItem> parentMap = new HashMap<>();


    while(!q.isEmpty()) {
        NodeItem remItem = q.poll();
        newNode.childNodes = new ArrayList<>();

        Set<Node> usedNode = new HashSet<>();
        List<NodePair> commonNodes = new ArrayList<>();
        List<Node> nonContainingChildren = new ArrayList<>();
        List<Node> t1NodeChildNodes = remItem.t1Children;
        List<Node> t2NodeChildNodes = remItem.t2Children;


        //process the common Nodes
        for(int i = 0; i < t1NodeChildNodes.size(); i++) {
          for(int j = 0; j < t2NodeChildNodes.size(); j++) {
            if(t1NodeChildNodes.get(i).name.equals(t2NodeChildNodes.get(j).name)
                && !usedNode.contains(t2NodeChildNodes.get(j))) {
              commonNodes.add(new NodePair(t1NodeChildNodes.get(i), t2NodeChildNodes.get(j)));
              usedNode.add(t2NodeChildNodes.get(j));
              usedNode.add(t1NodeChildNodes.get(i));
            }
          }
        }

        if(!commonNodes.isEmpty()) {
          for(NodePair currentPair: commonNodes) {
            Node node = new Node();
            node.name = currentPair.firstNode.name;
            node.value = currentPair.secondNode.value;
            q.add(new NodeItem(node, currentPair.firstNode.childNodes, currentPair.secondNode.childNodes));
            newNode.childNodes.add(node);
          }
        }

        //process the uncommon nodes
        //from t1 children
        for(Node node: t1NodeChildNodes) {
          if(!usedNode.contains(node)) {
            nonContainingChildren.add(node);
          }
        }

        // from t2 children
        for(Node node: t2NodeChildNodes) {
          if(!usedNode.contains(node)) {
            nonContainingChildren.add(node);
          }
        }

        newNode.childNodes.addAll(nonContainingChildren);

    }
    return resultRoot;
  }


  public static void main(String[] args) {
    Node t1 = new Node();
    t1.name = "ROOT";
    t1.value = "valueT1";
    t1.childNodes = new ArrayList<>();

    Node alphaNode = new Node();
    alphaNode.name = "A";
    alphaNode.value = "alpha";
    alphaNode.childNodes = new ArrayList<>();
    t1.childNodes.add(alphaNode);

    Node gammaNode = new Node();
    gammaNode.name = "B";
    gammaNode.value = "gamma";
    gammaNode.childNodes = new ArrayList<>();
    t1.childNodes.add(gammaNode);



  }
}
