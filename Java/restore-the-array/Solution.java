public class Solution {
    public int numberOfArrays(String s, int k) {
        return DFS(s, k, 0, new int[s.length()]);
    }

    public int DFS(String s, int k, int index, int[] results) {
        if(index == s.length())
            return 1;

        if(s.charAt(index) == '0')
            return 0;
        
        if(results[index] != 0)
            return results[index];
        
        int result = 0;
        int number = 0;
        int digit;
        for(int i = index; i < s.length(); i++) {
            digit = s.charAt(i) - '0';
            number = number * 10 + digit;
            
            if(k < number) {
                return 0;
            }

            result = (result + DFS(s, k, i + 1, results)) % 1000000007;
        }
        results[index] = result;
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArrays("1000", 10000));
        System.out.println(new Solution().numberOfArrays("1000", 10));
        System.out.println(new Solution().numberOfArrays("1317", 2000));
    }
}
