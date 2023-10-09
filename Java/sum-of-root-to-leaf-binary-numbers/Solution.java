class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode root, int pow) {
         if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
            return pow + root.val;
        }

        return sumRootToLeaf(root.left, 2 * ( pow + root.val)) + sumRootToLeaf(root.right, 2 * ( pow + root.val));
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)), new TreeNode(1, new TreeNode(0, null, null), new TreeNode(1, null, null)));
        Solution s = new Solution();
        System.out.println(s.sumRootToLeaf(tree1));
    }
}
