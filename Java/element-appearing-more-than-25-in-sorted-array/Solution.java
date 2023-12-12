public class Solution {
    public int findSpecialInteger(int[] arr) {
        int freq = arr.length / 4, count = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1])
                count++;
            else
                count = 1;
            
            if(count > freq)
                return arr[i-1];
        }

        return arr[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findSpecialInteger(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(s.findSpecialInteger(new int[] {1, 2, 3, 3}));
    }
}
