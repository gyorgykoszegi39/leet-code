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

    int result = 0;
    public int findTilt(TreeNode root) {
        calculateTilt(root);
        return result;
    }

    public int calculateTilt(TreeNode root) {
        if(root == null)
            return 0;

        int rightSum = calculateTilt(root.left);
        int leftSum = calculateTilt(root.right);

        result += Math.abs(leftSum - rightSum);
        return root.val + rightSum + leftSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree1 = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        TreeNode tree2 = new TreeNode(4,  new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));

        System.out.println(s.findTilt(tree1));
        System.out.println(s.findTilt(tree2));
    }
}
