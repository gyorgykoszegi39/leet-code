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
    public int sumOfLeftLeaves(TreeNode root, boolean... isLeft) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null && isLeft.length > 0 && isLeft[0])
            return root.val;

        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
        Solution s = new Solution();
        System.out.println(s.sumOfLeftLeaves(tree1));
    }
}
