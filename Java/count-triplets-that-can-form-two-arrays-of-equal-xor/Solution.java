public class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int xor = 0;
            for(int j = i; j < arr.length; j++){
                xor ^= arr[j];
                if(xor == 0) 
                    count += (j - i);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countTriplets(new int[] {2, 3, 1, 6, 7}));
    }
}
