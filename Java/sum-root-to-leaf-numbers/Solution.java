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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return root.val;

        return count(root, 0);
    }

    private int count(TreeNode root, int number) {
        if(root.left == null && root.right == null) {
            System.out.println(number);
            return number * 10 + root.val;
        }

        int sum = 0;
        if(root.left != null)
            sum += count(root.left, number * 10 + root.val);

        if(root.right != null)
            sum += count(root.right, number * 10 + root.val);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        Solution s = new Solution();
        System.out.println(s.sumNumbers(tree1));
    }
}
