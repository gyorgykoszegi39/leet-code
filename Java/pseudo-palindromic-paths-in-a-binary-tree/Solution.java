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
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPalindromicPaths(root, 0);
    }

    private int countPalindromicPaths(TreeNode node, int evenNrOfDigits) {
        if(node == null)
            return 0;
        
        evenNrOfDigits ^= (1 << node.val);
        if(node.left == null && node.right == null) {
            return (evenNrOfDigits & (evenNrOfDigits - 1)) == 0 ? 1 : 0;
        }

        return countPalindromicPaths(node.left, evenNrOfDigits) 
            + countPalindromicPaths(node.right, evenNrOfDigits);
    }

    private int countPalindromicPaths1(TreeNode node, boolean[] evenNrOfDigits, int countDiff) {
        if(node == null)
            return 0;
        
        evenNrOfDigits[node.val] = !evenNrOfDigits[node.val];
        countDiff += (evenNrOfDigits[node.val] ? 1 : -1);

        if(node.left == null && node.right == null) {
            return countDiff < 2 ? 1 : 0;
        }

        return countPalindromicPaths1(node.left, evenNrOfDigits.clone(), countDiff) 
            + countPalindromicPaths1(node.right, evenNrOfDigits.clone(), countDiff);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(2,
                                    new TreeNode(3,
                                                new TreeNode(3, null, null),
                                                new TreeNode(1, null, null)
                                    ),
                                    new TreeNode(1, 
                                                null, 
                                                new TreeNode(1, null, null))
                                    );
        
        System.out.println(s.pseudoPalindromicPaths(tree));
    }
}
