import java.util.ArrayDeque;
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
    int maxDepth;
    int mostLeftValueRec;

    public void BFS(TreeNode node, int depth) {
        if(node == null)
            return;

        if(depth > maxDepth) {
            maxDepth = depth;
            mostLeftValueRec = node.val;
        }

        BFS(node.left, depth + 1);
        BFS(node.right, depth + 1);
    }
    
    public int findBottomLeftValue(TreeNode root) {
        mostLeftValueRec = 0;
        maxDepth = 0;

        BFS(root, 0);
        return mostLeftValueRec;
    }
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        int mostLeftValue = 0;
        TreeNode node;

        nodes.add(root);

        while(!nodes.isEmpty()) {

            mostLeftValue = nodes.peek().val;
            int n = nodes.size();
            for(int i = 0; i < n; i++) {
                node = nodes.poll();

                if(node.left != null)
                    nodes.add(node.left);

                if(node.right != null)
                    nodes.add(node.right);
            }
        }
        
        return mostLeftValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(1,
                                    new TreeNode(5,
                                                null,
                                                new TreeNode(4,
                                                            new TreeNode(9, null, null),
                                                            new TreeNode(2, null, null))),
                                    new TreeNode(3,
                                                new TreeNode(10, null, null),
                                                new TreeNode(6, null, null)));
        
        System.out.println(s.findBottomLeftValue(tree));

        TreeNode tree1 = new TreeNode(1,
                                    new TreeNode(2,
                                                new TreeNode(3,
                                                            new TreeNode(4, 
                                                                        new TreeNode(5, null, null), null),
                                                            null),
                                                null),
                                    null);
        
        System.out.println(s.findBottomLeftValue(tree1));
    }
}
