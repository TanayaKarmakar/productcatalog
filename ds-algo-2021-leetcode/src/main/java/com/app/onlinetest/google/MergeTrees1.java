package com.app.onlinetest.google;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

public class MergeTrees1 {
  static class Node {
    String name;
    String value;
    List<Node> childNodes;
  }

  static class NodePair {
    Node t1Node;
    Node t2Node;

    public NodePair(Node t1Node, Node t2Node) {
      this.t1Node = t1Node;
      this.t2Node = t2Node;
    }
  }

  private static Node merge(Node t1, Node t2) {
    if(t1 == null && t2 == null)
      return null;
    if(t1 == null || t2 == null) {
      if(t1 == null)
        return t2;
      if(t2 == null)
        return t1;
    }
    t1.value = t2.value;
    List<Node> t1Children = t1.childNodes;
    List<Node> t2Children = t2.childNodes;
    List<NodePair> allNodePairs = new ArrayList<>();
    Set<Node> usedNode = new HashSet<>();
    for(int i = 0; i < t1Children.size(); i++) {
      for(int j = 0; j < t2Children.size(); j++) {
        if(t1Children.get(i).name.equals(t2Children.get(j).name)
        && !usedNode.contains(t2Children.get(j))) {
          NodePair nodePair = new NodePair(t1Children.get(i), t2Children.get(j));
          allNodePairs.add(nodePair);
          usedNode.add(t2Children.get(j));
          usedNode.add(t1Children.get(i));
        }
      }
    }

    // children which are part of t1 but not t2
    for(int i = 0; i < t1Children.size(); i++) {
      if(!usedNode.contains(t1Children.get(i))) {
        allNodePairs.add(new NodePair(t1Children.get(i), null));
      }
    }

    // children which are part of t2 but not t1
    for(int i = 0; i < t2Children.size(); i++) {
      if(!usedNode.contains(t2Children.get(i))) {
        allNodePairs.add(new NodePair(null, t2Children.get(i)));
      }
    }

    t1.childNodes = new ArrayList<>();
    for(NodePair currentNodePair: allNodePairs) {
      t1.childNodes.add(merge(currentNodePair.t1Node, currentNodePair.t2Node));
    }
    return t1;
  }

  public static void main(String[] args) {
    MergeTrees.Node t1 = new MergeTrees.Node();
    t1.name = "ROOT";
    t1.value = "valueT1";
    t1.childNodes = new ArrayList<>();

    MergeTrees.Node alphaNode = new MergeTrees.Node();
    alphaNode.name = "A";
    alphaNode.value = "alpha";
    alphaNode.childNodes = new ArrayList<>();
    t1.childNodes.add(alphaNode);

    MergeTrees.Node gammaNode = new MergeTrees.Node();
    gammaNode.name = "B";
    gammaNode.value = "gamma";
    gammaNode.childNodes = new ArrayList<>();
    t1.childNodes.add(gammaNode);
  }
}
