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
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        TreeNode saveTreeNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(saveTreeNode);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        System.out.println(tree.val + " " + tree.left.val + " " + tree.right.val);

        Solution s = new Solution();
        TreeNode result = s.invertTree(tree);
        System.out.println(result.val + " " + result.left.val + " " + result.right.val);
    }
}
