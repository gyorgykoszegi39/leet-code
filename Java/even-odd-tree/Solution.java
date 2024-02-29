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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        int prevValue, n = 0, isOddLevel = 1;
        TreeNode node;

        nodes.add(root);

        while(!nodes.isEmpty()) {
            n = nodes.size();
            isOddLevel = 1 - isOddLevel;
            prevValue = nodes.peek().val + (isOddLevel == 0 ? -1 : 1);
            for(int i = 0; i < n; i++) {
                node = nodes.poll();
                
                if(node.val % 2 == isOddLevel)
                    return false;

                if(isOddLevel == 1 && prevValue <= node.val)
                    return false;
                
                if(isOddLevel == 0 && prevValue >= node.val)
                    return false;

                prevValue = node.val;

                if(node.left != null)
                    nodes.add(node.left);

                if(node.right != null)
                    nodes.add(node.right);
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(1,
                                    new TreeNode(10,
                                                null,
                                                new TreeNode(3,
                                                            new TreeNode(12, null, null),
                                                            new TreeNode(8, null, null))),
                                    new TreeNode(4,
                                                new TreeNode(7, 
                                                    new TreeNode(6, null, null),
                                                    null),
                                                new TreeNode(9, 
                                                    null,
                                                    new TreeNode(2, null, null)))
                                    );
        
        System.out.println(s.isEvenOddTree(tree));

        TreeNode tree1 = new TreeNode(1,
                                    new TreeNode(2,
                                                new TreeNode(3,
                                                            new TreeNode(4, 
                                                                        new TreeNode(5, null, null), null),
                                                            null),
                                                null),
                                    null);
        
        System.out.println(s.isEvenOddTree(tree1));
    }
}
