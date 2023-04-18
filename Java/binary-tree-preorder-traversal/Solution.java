import java.util.ArrayList;
import java.util.List;

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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrList = new ArrayList<Integer>();

        if(root == null)
            return arrList;
        
        arrList.add(root.val);
        arrList.addAll(preorderTraversal(root.left));
        arrList.addAll(preorderTraversal(root.right));
        return arrList;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = null;
        tree.right = new TreeNode(2, new TreeNode(3, null, null), null);

        System.out.println(Solution.preorderTraversal(tree));
    }
}
