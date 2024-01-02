import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] count = new int[201];

        for(int num : nums) {
            if(result.size() <= count[num]) {
                result.add(new ArrayList<Integer>());
            }
            result.get(count[num]).add(num);
            count[num]++;
        }

        return result;
    }
    
    public List<List<Integer>> findMatrix1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] count = new int[201];

        for(int num : nums)
            count[num]++;

        for(int i = 1; i <= 200; i++) {
            for(int j = 0; j < count[i]; j++) {
                if(result.size() <= j) {
                    result.add(new ArrayList<Integer>());
                }
                result.get(j).add(i);
            }
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.findMatrix(new int[] {1, 3, 4, 1, 2, 3, 1});

        for(List<Integer> row : result) {
            for(Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
    }
}
