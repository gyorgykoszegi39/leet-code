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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        if(root.val >= low && root.val <= high)
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

        if(root.val < low)
            return rangeSumBST(root.right, low, high);
        
        if(root.val > high)
            return rangeSumBST(root.left, low, high);

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(10,
                                new TreeNode(5,
                                            new TreeNode(3, null, null),
                                            new TreeNode(7, null, null)),
                                new TreeNode(15, 
                                            null, 
                                            new TreeNode(18, null, null)));

        System.out.println(s.rangeSumBST(tree, 7, 15));
    }
}
