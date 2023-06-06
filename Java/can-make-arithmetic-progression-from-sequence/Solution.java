import java.util.Arrays;

public class Solution {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(diff != arr[i] - arr[i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {3,5,1}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {-3,-5,-1, 1}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {1,2,4}));
    }
}
