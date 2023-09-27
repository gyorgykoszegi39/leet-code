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

    public boolean isBalanced(TreeNode root) {
        return depth(root) != 0;
    }

    public int depth(TreeNode root) {
        if(root == null)
            return 1;

        int left = depth(root.left);
        int right = depth(root.right);
        if(left == 0 || right == 0 || Math.abs(left - right) > 1)
            return 0;

        return Math.max(left, right) + 1;    
    }


    
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree1 = new TreeNode(1,  new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null));
        TreeNode tree2 = new TreeNode(1,  new TreeNode(2), new TreeNode(3));

        System.out.println(s.isBalanced(tree1));
        System.out.println(s.isBalanced(tree2));

    }
}
