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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();

        preorderTraversal(root, result);

        return result.toString();
    }

    public void preorderTraversal(TreeNode node, StringBuilder result) {
        if(node == null)
            return;

        result.append(node.val);

        if(node.left == null && node.right == null)
            return;

        result.append("(");
        preorderTraversal(node.left, result);
        result.append(")");
        
        if(node.right != null ) {
            result.append("(");
            preorderTraversal(node.right, result);
            result.append(")");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode node = new TreeNode(1, 
                            new TreeNode(2,
                                null,
                                new TreeNode(4, null, null)), 
                            new TreeNode(3, null, null));
        
        TreeNode node1 = new TreeNode(1, 
            new TreeNode(2,
                new TreeNode(4, null, null), null), 
            new TreeNode(3, null, null));

        System.out.println(s.tree2str(node));
        System.out.println(s.tree2str(node1));
    }
}
