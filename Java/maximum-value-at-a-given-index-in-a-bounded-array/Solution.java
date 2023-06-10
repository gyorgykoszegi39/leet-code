
public class Solution {

    public static int maxValue(int n, int index, int maxSum) {
        maxSum -= n;

        if(maxSum <= 0) {
            return 1;
        }

        int left = 0, right = maxSum, mid;
        while(left < right) {
            mid = (left + right + 1) / 2;
            
            if(isMin(n - 1, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    public static long isMin(int n, int i, int mid) {
        long x = Math.max(mid - i, 0);
        long sum = (mid + x) * (mid - x + 1) / 2;
        x = Math.max(mid - (n - i), 0);
        sum += (mid + x) * (mid - x + 1) / 2;
        return sum - mid;
    }
    
    public static void main(String[] args) {
        System.out.println(Solution.maxValue(6, 1, 10));
        System.out.println(Solution.maxValue(3, 2, 3));
        System.out.println(Solution.maxValue(4, 2, 6));
        System.out.println(Solution.maxValue(3, 2, 18));
        System.out.println(Solution.maxValue(8, 2, 546824536)); // 68353069

    }
}

/*
    1 1 1
    1 2 1
    2 3 2
    3 4 3
    3 5 3

    1 1 1 1 1 1


 */
