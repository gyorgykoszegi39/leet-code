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
    private int time = 0;
    public int amountOfTime(TreeNode root, int start) {
        depth(root, start);
        return time;
    }

    public int depth(TreeNode root, int target) {
        if(root == null)
            return 0;

        int leftDepth = depth(root.left, target);
        int rightDepth = depth(root.right, target);
        
        if(root.val == target) {
            time = Math.max(leftDepth, rightDepth);
            return -1;
        } else if(leftDepth >= 0 && rightDepth >= 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        }

        time = Math.max(time, Math.abs(leftDepth - rightDepth));
        return Math.min(leftDepth, rightDepth) - 1;
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
        
        System.out.println(s.amountOfTime(tree, 3));
        System.out.println(s.amountOfTime(tree, 6));

        TreeNode tree1 = new TreeNode(1,
                                    new TreeNode(2,
                                                new TreeNode(3,
                                                            new TreeNode(4, 
                                                                        new TreeNode(5, null, null), null),
                                                            null),
                                                null),
                                    null);
        
        System.out.println(s.amountOfTime(tree1, 2));
    }
}
