public class Solution {

    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int pivot = (int) Math.sqrt(sum);
        
        return pivot * pivot == sum ? pivot : -1;
    }

    public int pivotInteger1(int n) {
        if(n == 1)
            return 1;

        int left = 0, right = n;
        int sumLeft = 0, sumRight = 0;
        while(left < right) {
            if(sumLeft < sumRight) {
                sumLeft += left;
                left++;
            } else {
                sumRight += right;
                right--;
            }
        }
        
        return sumLeft == sumRight ? left : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.pivotInteger(1));
        System.out.println(s.pivotInteger(4));
        System.out.println(s.pivotInteger(8));
    }
}
