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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return  hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        Solution s = new Solution();
        System.out.println(s.hasPathSum(tree, 5));
        System.out.println(s.hasPathSum(tree, 4));

    }
}
