package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;
import common.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class MaximumWidthOfBinaryTree {
    private static int maxWidth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ans = Integer.max(size, ans);
            for(int i = 0; i < size; i++) {
                TreeNode remNode = q.poll();
                if(remNode.left != null)
                    q.add(remNode.left);
                if(remNode.right != null)
                    q.add(remNode.right);
            }
        }
        return ans;
    }


    private static int maxWidth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int first = 0;
        int last = 0;

        int ans = 1;

        q.add(new Pair<>(root, 1));
        while(!q.isEmpty()) {
            int size = q.size();
            int minLevel = q.peek().second;
            first = 0;
            last = 0;
            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> remNode = q.poll();
                int currLevel = remNode.second - minLevel;
                if(i == 0)
                    first = remNode.second;
                if(i == size - 1)
                    last = remNode.second;

                if(remNode.first.left != null)
                    q.add(new Pair<>(remNode.first.left, 2 * currLevel + 1));
                if(remNode.first.right != null)
                    q.add(new Pair<>(remNode.first.right, 2 * currLevel + 2));
            }
            ans = Integer.max(ans, (last - first + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(20);
        bt.root.right = new TreeNode(30);
        bt.root.left.left = new TreeNode(40);
        bt.root.left.right = new TreeNode(50);
        bt.root.right.left = new TreeNode(60);

        int ans = maxWidth(bt.root);

        System.out.println(ans);

        ans = maxWidth1(bt.root);
        System.out.println(ans);
    }
}
