import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final long MOD = 1000000007;
    private long[][] pascalTriangle;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        createPascalTriangle(n);
        List<Integer> numbers= new ArrayList<Integer>();
        for(Integer num : nums)
            numbers.add(num);

        return (int) getCombinations(numbers) - 1;
    }

    private long getCombinations(List<Integer> numbers) {

        if(numbers.size() <= 2) {
            return 1;
        }

        int root = numbers.get(0);
        List<Integer> leftTree = new ArrayList<Integer>(), rightTree = new ArrayList<Integer>();
        for(Integer number: numbers) {
            if(number < root) {
                leftTree.add(number);
            } else if(number > root) {
                rightTree.add(number);
            }
        }
        
        
        
        return (pascalTriangle[numbers.size() - 1][leftTree.size()] * (getCombinations(leftTree)) % MOD);
    }

    private void createPascalTriangle(int n) {
        pascalTriangle = new long[n][n];

        for(int i = 0; i < n; i++) {
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
        }

        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++)
                pascalTriangle[i][j] = (pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]) % MOD;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfWays(new int[] {3, 4, 5, 2, 1}));
    }
}