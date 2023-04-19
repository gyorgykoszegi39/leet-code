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
    private int result = 0;
    public int longestZigZag(TreeNode root) {

        DFS(root, false);
        return this.result;
    }

    private int DFS(TreeNode node, Boolean isLeft) {
        if(node == null)
            return -1;

        int left = DFS(node.left, false);
        int right = DFS(node.right, true);
        result = Math.max(result, Math.max(left + 1, right + 1));

        return isLeft ?  left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = null;
        tree.right = new TreeNode(1, 
        new TreeNode(1, null, null), 
        new TreeNode(1, 
            new TreeNode(1, 
                null, 
                new TreeNode(1, 
                    null, 
                    new TreeNode(1, null, null))),
        new TreeNode(1, null, null)
                ));
        
        
        

        System.out.println(new Solution().longestZigZag(tree));
    }
}
