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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Solution s = new Solution();
        System.out.println(s.maxDepth(tree1));
    }
}
