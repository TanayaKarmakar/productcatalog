package tree;

import common.BinaryTree;
import common.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 19/04/22
 * @project ds-algo-2021
 */
public class SerializeDeserialize {
    private static int indx = 0;

    private static void serialize(TreeNode root, List<Integer> list) {
        if(root == null) {
            list.add(Integer.MAX_VALUE);
            return;
        }
        list.add(root.val);
        serialize(root.left, list);
        serialize(root.right, list);
    }

    private static TreeNode deserialize(List<Integer> list) {
        if(indx >= list.size())
            return null;
        int val = list.get(indx);
        indx++;
        if(val == Integer.MAX_VALUE)
            return null;
        TreeNode root = new TreeNode(val);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    private static void pre(TreeNode root) {
        if(root == null)
            return;
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        List<Integer> list = new ArrayList<>();
        serialize(bt.root, list);

        System.out.println(list);

        indx = 0;
        BinaryTree bt1 = new BinaryTree();
        bt1.root = deserialize(list);
        pre(bt1.root);
    }
}
