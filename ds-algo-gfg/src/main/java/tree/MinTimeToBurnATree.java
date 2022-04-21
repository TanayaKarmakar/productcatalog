package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class MinTimeToBurnATree {
    private static int minTime(TreeNode root, TreeNode node) {
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
        buildMap(root, null, parentChildMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode remNode = q.poll();
                visited.add(remNode);

                if(remNode.left != null && !visited.contains(remNode.left)) {
                    q.add(remNode.left);
                }
                if(remNode.right != null && !visited.contains(remNode.right)) {
                    q.add(remNode.right);
                }

                TreeNode parentNode = parentChildMap.get(remNode);
                if(parentNode != null && !visited.contains(parentNode))
                    q.add(parentNode);
            }
            count++;
        }
        return count;
    }

    private static void buildMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentChildMap) {
        if(root == null)
            return;
        parentChildMap.put(root, parent);
        buildMap(root.left, root, parentChildMap);
        buildMap(root.right, root, parentChildMap);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.left.right = new TreeNode(7);
        bt.root.right.left = new TreeNode(5);
        bt.root.right.right = new TreeNode(6);

        int ans = minTime(bt.root, bt.root.left);

        System.out.println(ans);
    }
}
