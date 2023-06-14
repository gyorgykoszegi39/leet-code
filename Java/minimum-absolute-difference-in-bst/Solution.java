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
    private int minValue = Integer.MAX_VALUE;
    private TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);

        return minValue;
    }

    public void inorder(TreeNode node) {
        if(node == null)
            return;
        
        inorder(node.left);
        if(prevNode != null)
            minValue = Math.min(minValue, node.val - prevNode.val);
        prevNode = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(4, 
            new TreeNode(2, 
                new TreeNode(1), 
                new TreeNode(3)), 
            new TreeNode(16));
        
        System.out.println(s.getMinimumDifference(tree));
    }
}
