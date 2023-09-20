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
    

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        TreeNode tree2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        TreeNode tree3 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(3)), new TreeNode(2, new TreeNode(3), new TreeNode(4)));
        TreeNode tree4 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(2, new TreeNode(3), new TreeNode(4)));

        Solution s = new Solution();
        System.out.println(s.isSymmetric(tree1));
        System.out.println(s.isSymmetric(tree2));
        System.out.println(s.isSymmetric(tree3));
        System.out.println(s.isSymmetric(tree4));
    }
}
