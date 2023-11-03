import java.util.ArrayList;

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
    private int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if(root == null)
            return new int[] {0, 0};

        if(root.left == null && root.right == null) {
            count++;
            return new int[] {root.val, 1};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = root.val + left[0] + right[0];
        int nrOfNodes = 1 + left[1] + right[1];
        if(sum / nrOfNodes == root.val)
            count++;
        System.out.println(sum);
        return new int[] {sum, nrOfNodes};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(4, 
                            new TreeNode(8, 
                                new TreeNode(0, null, null), 
                                new TreeNode(1, null, null)
                            ),
                            new TreeNode(5,
                                null,
                                new TreeNode(6, null, null)));

        System.out.println(s.averageOfSubtree(tree));
    }
    
}
