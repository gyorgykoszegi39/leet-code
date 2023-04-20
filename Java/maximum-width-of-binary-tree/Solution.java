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

    private int result = 0;
    public int widthOfBinaryTree(TreeNode root) {
        DFS(root, 0, new ArrayList<Integer>(), 0);
        return this.result;
    }

    public void DFS(TreeNode node, int index, List<Integer> leftMostNodes, int level) {
        if(node != null) {

            if(level == leftMostNodes.size()) {
                leftMostNodes.add(index);
            }
            this.result = Math.max(result, index - leftMostNodes.get(level) + 1);
            DFS(node.left, index * 2, leftMostNodes, level + 1);
            DFS(node.right, index * 2 + 1, leftMostNodes, level + 1);
        }
    }
    public static void main(String[] args) {
        /*TreeNode tree = new TreeNode(
            1,
            new TreeNode(
                3, 
                new TreeNode(
                    5, 
                    null, 
                    null), 
                null),
            new TreeNode(2, null, null)
        );*/

        TreeNode tree = new TreeNode(
            1,
            new TreeNode(
                3,
                new TreeNode(5),
                new TreeNode(3)
            ),
            new TreeNode(
                2,
                null,
                new TreeNode(9)
            )

        );

        System.out.println(new Solution().widthOfBinaryTree(tree));
    }
}
