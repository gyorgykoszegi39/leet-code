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
    private int prevVal;
    private int count = 0;
    private int max = 0;
    private ArrayList<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void inorder(TreeNode root) {
        if(root == null)
            return;

        inorder(root.left);
        countVal(root.val);
        inorder(root.right);
    }

    private void countVal(int val) {
        if(prevVal != val) {
            prevVal = val;
            count = 0;
        }
        count++;

        if(max == count) {
            result.add(val);
        } else if(max  < count) {
            max = count;
            result.clear();
            result.add(val);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(2, null, null), null));

        for(Integer number : s.findMode(tree1))
            System.out.println(number);
    }
}
