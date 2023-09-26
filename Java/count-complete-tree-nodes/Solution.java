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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int countLeft = 1, countRight = 1;

        TreeNode leftNode = root.left, rightNode = root.right;
        while(leftNode != null) {
            countLeft++;
            leftNode = leftNode.left;
        }

        while(rightNode != null) {
            countRight++;
            rightNode = rightNode.right;
        }

        if(countLeft == countRight)
            return (int)Math.pow(2, countLeft) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        System.out.println(s.countNodes(tree));
    }
}
