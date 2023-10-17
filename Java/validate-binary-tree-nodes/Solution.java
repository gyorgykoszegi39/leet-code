import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] used = new int[n];
        int i, count = 0;
        for(i = 0; i < n; i++) {
            if(leftChild[i] >= 0) {
                if(used[leftChild[i]] == 0) {
                    used[leftChild[i]] = 1;
                    count++;
                }
                else
                    return false;
            }
            if(rightChild[i] >= 0) {
                if(used[rightChild[i]] == 0) {
                    used[rightChild[i]] = 1;
                    count++;
                }
                else
                    return false;
            }
        }

        if(count != n -1)
            return false;
        int root = 0;
        for(i = 0; i < n; i++) {
            if(used[i] != 1)
                root = used[i];
        }
        Deque<Integer> tree = new ArrayDeque<>();
        if(leftChild[root] >= 0) {
            tree.add(leftChild[root]);
            used[leftChild[root]] = 1;
        }
        if(rightChild[root] >= 0) {
            tree.add(rightChild[root]);
            used[rightChild[root]] = 1;
        }
        while(!tree.isEmpty()) {
            i = tree.pop();

            if(leftChild[i] >= 0) {
                if(used[leftChild[i]] == 0)
                    return false;
                tree.add(leftChild[i]);
                used[leftChild[i]] = 0;
            }
            if(rightChild[i] >= 0) {
                if(used[rightChild[i]] == 0)
                    return false;
                tree.add(rightChild[i]);
                used[rightChild[i]] = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, -1, -1, -1}));
        System.out.println(s.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, 3, -1, -1}));
    }
}
