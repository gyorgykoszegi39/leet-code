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

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        int depth = 0;
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int n = nodes.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = nodes.poll();

                if(node.left == null && node.right == null)
                    return depth + 1;

                if(node.left != null)
                    nodes.add(node.left);

                if(node.right != null)
                    nodes.add(node.right);
            }
            depth++;
        }

        return depth;
    }

    public int recursionMinDepth(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        
        }
        
        if(root.left == null &&  root.right == null) {
            return 1;
        }

        return 1 + Math.min(recursionMinDepth(root.left), recursionMinDepth(root.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(3, null, new TreeNode(5, null, new TreeNode(7))));
        TreeNode tree2 = new TreeNode(4,  new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));

        System.out.println(s.minDepth(tree1));
        // /System.out.println(s.minDepth(tree2));
    }
}
