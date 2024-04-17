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

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder result = new StringBuilder();
        smallestFromLeaf(root, new StringBuilder(), result);
        return result.toString();
    }
    
    private void smallestFromLeaf(TreeNode node, StringBuilder buildResult, StringBuilder result) {
        if (node == null)
            return;
        
        buildResult.append((char)('a' + node.val));
        
        if (node.left == null && node.right == null) {
            StringBuilder reversedString = buildResult.reverse();
            if (result.length() == 0 || result.compareTo(reversedString) > 0) {
                result.setLength(0);
                result.append(reversedString);
            }
        }
        
        smallestFromLeaf(node.left, buildResult, result);
        smallestFromLeaf(node.right, buildResult, result);
        
        buildResult.setLength(buildResult.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(0, new TreeNode(1, new TreeNode(3, null, null), new TreeNode(4, null, null)), new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)));

        System.out.println(s.smallestFromLeaf(tree));
        
    }
}
