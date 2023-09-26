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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr = new ArrayList<>();
        buildPath(root, new StringBuilder(), arr);
        return arr;
    }

    public void buildPath(TreeNode root, StringBuilder path, List<String> arr) {
        if(root != null) {
            int len = path.length();

            if(len > 0) {
                path.append("->");
            }
            path.append(root.val);

            buildPath(root.left, path, arr);
            buildPath(root.right, path, arr);

            if(root.left == null && root.right == null) {
                arr.add(path.toString());
            }
            path.setLength(len);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(1,  new TreeNode(2), new TreeNode(3));

        for(String result : s.binaryTreePaths(tree)) {
            System.out.println(result);
        }
    }
}
