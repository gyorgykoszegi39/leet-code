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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return max;
    }

    public int calculateDiameter(TreeNode root) {
        if(root == null)
            return 0;

        int left = calculateDiameter(root.left);
        int right = calculateDiameter(root.right);
        max = Math.max(max, left + right);
       
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,  new TreeNode(2), new TreeNode(3));

        Solution s = new Solution();
        System.out.println(s.diameterOfBinaryTree(tree));
    }
}
