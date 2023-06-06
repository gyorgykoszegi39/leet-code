import java.util.Arrays;

public class Solution {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        int min = arr[0], max = min;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        if((max - min) % (n - 1) != 0)
            return false;

        int diff = (max - min) / (n - 1);

        int tmp, pos, i = 0;
        while (i < n) {
            if(arr[i] == (diff * i) + min)
                i++;
            else if((arr[i] - min) % diff != 0)
                return false;
            else {
                pos = (arr[i] - min) / diff;

                if(pos < i || arr[i] == arr[pos])
                    return false;

                tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {3, 5, 1}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {-3, -5, -1, 1}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {1, 2, 4}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {0, 0, 0, 0}));
        System.out.println(Solution.canMakeArithmeticProgression(new int[] {1, 2, 3, 2, 5}));
    }
}
