package week2.problem.treeTranversal.PostOrder;

/**
 * auther wudirex
 * 2021-04-12
 * tree traversal in inorder using recursion
 */
public class solution {

    public static void traversal(TreeNode root) {
        if(root.left!=null)
            traversal(root.left);
        if(root.right!=null)
            traversal(root.right);
        System.out.println("tree ->" + root.getData());
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
        traversal(root);
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
