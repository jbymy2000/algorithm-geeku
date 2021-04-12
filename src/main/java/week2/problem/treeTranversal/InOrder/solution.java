package week2.problem.treeTranversal.InOrder;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * auther wudirex
 * 2021-04-12
 * tree traversal in inorder using recursion
 */
public class solution {

    public static void traversal(TreeNode root) {
        if(root.left!=null)
            traversal(root.left);
        System.out.println("tree ->" + root.getData());
        if(root.right!=null)
            traversal(root.right);
    }

    public static void traversalRecursive(TreeNode root) {
        List<TreeNode> tree = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            tree.add(root);
            root = root.right;
        }
        tree.forEach(o->{System.out.print(o.data);});
    }

    public static void main(String[] argvs){
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode leftleft = new TreeNode();
        TreeNode leftright = new TreeNode();

        root.setData("1");
        left.setData("2");
        right.setData("3");
        leftleft.setData("4");
        leftright.setData("5");
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftleft);
        left.setRight(leftright);
        traversalRecursive(root);
    }

    public static class TreeNode{
        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        String data;

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        TreeNode left;

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        TreeNode right;
    }
}
