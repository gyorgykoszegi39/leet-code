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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        TreeNode tree2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Solution s = new Solution();
        System.out.println(s.isSameTree(tree1, tree2));
    }
}
