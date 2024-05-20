import java.util.Stack;

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
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1)
            return true;

        if(root.val == 0)
            return false;
        
        return root.val == 2 ? (evaluateTree(root.left) || evaluateTree(root.right)) : (evaluateTree(root.left) && evaluateTree(root.right));
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(0, null, null), new TreeNode(1, null, null));
        Solution s = new Solution();
        System.out.println(s.evaluateTree(tree));
    }
}
