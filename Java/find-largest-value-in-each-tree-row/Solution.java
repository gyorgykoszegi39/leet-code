import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> largestValues(TreeNode root) {
        int n, maxNode;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        if(root != null) {
            nodes.add(root);
        }

        while(!nodes.isEmpty()) {
            n = nodes.size();
            maxNode = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                root = nodes.poll();
                maxNode = Math.max(maxNode, root.val);

                if(root.left != null)
                    nodes.offer(root.left);
                if(root.right != null)
                    nodes.offer(root.right);
            }

            result.add(maxNode);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, 
                                        new TreeNode(3, 
                                            new TreeNode(5, null, null), 
                                            new TreeNode(3, null, null)), 
                                        new TreeNode(2, 
                                            new TreeNode(9, null, null), 
                                            new TreeNode(7, null, null)));
        Solution s = new Solution();
        System.out.println(s.largestValues(tree1));
    }
}