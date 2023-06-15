import java.util.ArrayList;
import java.util.HashMap;

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
    
    HashMap<Integer, Integer> levelSums = new HashMap<Integer, Integer>();
    public int maxLevelSum(TreeNode root) {
        DFS(root, 0);
        int maxSum = levelSums.get(0), result = 0;
        for(int i = 1; i < levelSums.size(); i++) {
            if(maxSum < levelSums.get(i)) {
                maxSum = levelSums.get(i);
                result = i;
            }
        }
        return result + 1;
    }

    private void DFS(TreeNode node, int level) {
        if(node == null)
            return;
            
        levelSums.put(level, node.val + levelSums.getOrDefault(level, 0));
        DFS(node.left, level + 1);
        DFS(node.right, level + 1);
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode tree = new TreeNode(1,
            new TreeNode(7,
                 new TreeNode(7),
                 new TreeNode(-8)),
            new TreeNode(0,
                new TreeNode(3),
                new TreeNode(4))
        );
        System.out.println(s.maxLevelSum(tree));
    }
}
