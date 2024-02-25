import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

class Solution {
    
    int[] parent;
    int[] count;

    int max;
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;

        for (int num : nums) {
            if(num == 1)
                return false;
            max = Math.max(max, num);
        }

        parent = new int[max +1];
        count = new int[max + 1];
        
        for(int i = 1; i <= max; i++)
            parent[i] = i;
        
        for(int num : nums)
            count[num]++;
        

        boolean[] visited = new boolean[max + 1];

        for(int i = 2; i * 2 <= max; i++) {
            if(visited[i])
                continue;
            
            for(int j = i + i; j <= max; j += i) {
                visited[j] = true;
                if(count[j] != 0)
                    union(i, j);
            }
        }

        int p = find(nums[0]);
        for(int i = 1; i < n; i++)
            if(find(nums[i]) != p) 
                return false;
        
        return true;
    }

    private int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
    
    private void union(int x, int y) {
        
        x = find(x);
        y = find(y);
        if (x == y) 
            return;

        parent[y] = x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canTraverseAllPairs(new int[] {2, 3, 6}));
        System.out.println(s.canTraverseAllPairs(new int[] {3, 9, 5}));
        System.out.println(s.canTraverseAllPairs(new int[] {4, 3, 12, 8}));
    }
}