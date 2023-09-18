import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList<>();
        
        if(root == null)
            return inorderTraversal;

        inorderTraversal.addAll(inorderTraversal(root.left));
        inorderTraversal.add(root.val);
        inorderTraversal.addAll(inorderTraversal(root.right));

        return inorderTraversal;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = null;
        tree.right = new TreeNode(2, new TreeNode(3, null, null), null);
        Solution s = new Solution();
        System.out.println(s.inorderTraversal(tree));
    }
}
