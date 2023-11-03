import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int j = 0;

        for(int i = 1; i <= n && j < target.length; i++) {
            ops.add("Push");
            if(i == target[j]) {
                j++;
            }
            else {
                ops.add("Pop");
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(String op : s.buildArray(new int[] {1, 3}, 4)) {
            System.out.println(op);
        }
    }
}