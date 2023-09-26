import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {

    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        int maxDepth = 0;
        if(root.children != null)
            for(Node child: root.children) {
                maxDepth = Math.max(maxDepth, maxDepth(child));
            }
            
        return maxDepth + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Node> level2 = new ArrayList<>();
        level2.add(new Node(5));
        level2.add(new Node(6));

        List<Node> level1 = new ArrayList<>();
        level1.add(new Node(3, level2));
        level1.add(new Node(2));
        level1.add(new Node(4));

        Node tree = new Node(1, level1);
        System.out.println(s.maxDepth(tree));
    }
}
