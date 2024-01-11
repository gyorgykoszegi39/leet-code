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
    public int maxAncestorDiff(TreeNode root) {
        return DFS(root, root.val, root.val);
    }

    public int DFS(TreeNode root, int min, int max) {
        if(root == null)
            return max - min;
        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        return Math.max(DFS(root.left, min, max), DFS(root.right, min, max));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(8,
                                    new TreeNode(3,
                                                new TreeNode(1, null, null),
                                                new TreeNode(6,
                                                            new TreeNode(4, null, null),
                                                            new TreeNode(7, null, null))),
                                    new TreeNode(10,
                                                null,
                                                new TreeNode(14, 
                                                            new TreeNode(13, null, null), 
                                                            null)
                                                )
                                    );
        
        System.out.println(s.maxAncestorDiff(tree));
        TreeNode tree1 = new TreeNode(1,
                                    null,
                            new TreeNode(2,
                                        null,
                                        new TreeNode(0, 
                                                    new TreeNode(3, null, null), 
                                                    null)
                                        )
                        );
        
        System.out.println(s.maxAncestorDiff(tree1));
    }
}