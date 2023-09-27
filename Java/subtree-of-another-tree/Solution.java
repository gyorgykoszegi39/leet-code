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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;

        if(dfs(root, subRoot))
            return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;

        if(root.val != subRoot.val)
            return false;
        
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode subTree = new TreeNode(2);
        TreeNode tree = new TreeNode(1,  subTree, new TreeNode(3));

        System.out.println(s.isSubtree(tree, tree));
        System.out.println(s.isSubtree(tree, subTree));

    }
}
