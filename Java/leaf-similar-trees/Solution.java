import java.util.ArrayList;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1Leafs = new ArrayList<>();
        ArrayList<Integer> t2Leafs = new ArrayList<>();
        getLeafs(root1, t1Leafs);
        getLeafs(root2, t2Leafs);

        return (t1Leafs).equals(t2Leafs);
    }

    private void getLeafs(TreeNode root, ArrayList<Integer> leafs) {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
           leafs.add(root.val);

        getLeafs(root.left, leafs);
        getLeafs(root.right, leafs);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)));
        Solution s = new Solution();
        System.out.println(s.leafSimilar(tree1, tree1));
    }
}
