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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if(root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }

    public void printTreeNode(TreeNode root) {
        if(root == null)
            return;

        System.out.println(root.val);

        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(0, null, null), new TreeNode(1, null, null));
        Solution s = new Solution();
        TreeNode result = s.removeLeafNodes(tree, 0);

        s.printTreeNode(result);
    }
}
