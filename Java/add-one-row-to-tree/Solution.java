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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 0 || depth == 1) {
            TreeNode extendRoot = new TreeNode(val);
            extendRoot.left = depth == 1 ? root : null;
            extendRoot.right = depth == 0 ? root : null;
            return extendRoot;
        }
        
        if (root != null) {
            root.left  = addOneRow(root.left,  val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        
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
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        Solution s = new Solution();
        TreeNode result = s.addOneRow(tree1, 4, 2);
        s.printTreeNode(result);
    }
}
