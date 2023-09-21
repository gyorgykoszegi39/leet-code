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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode result = new TreeNode(nums[mid]);

        result.left = buildTree(nums, 0, mid - 1);
        result.right = buildTree( nums, mid + 1, nums.length - 1);

        return result;
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode tree = new TreeNode(nums[mid]);

        tree.left =  buildTree(nums, left, mid - 1);
        tree.right = buildTree(nums, mid + 1, right);

        return tree;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
