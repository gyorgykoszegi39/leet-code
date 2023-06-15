import java.util.LinkedList;
import java.util.Queue;

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
    
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int maxSum = Integer.MIN_VALUE, result = 0, n, currentSum;
        TreeNode node;
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()) {
            currentSum = 0;
            n = queue.size();
            for(int i = 0; i < n; i++) {
                node = queue.poll();
                currentSum += node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            if(maxSum < currentSum) {
                maxSum = currentSum;
                result = level;
            }

            level++;
        }
        return result;
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
