import java.util.Arrays;

public class Solution {

    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);

        while(n > 0) {
            n--;
            for(int i = 1; i < 5; i++) {
                dp[i] += dp[i - 1];
            }
        }
        
        return dp[4];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countVowelStrings(1));
        System.out.println(s.countVowelStrings(2));
        System.out.println(s.countVowelStrings(3));
        System.out.println(s.countVowelStrings(4));
        System.out.println(s.countVowelStrings(5));
        System.out.println(s.countVowelStrings(6));


    }
}

/*
1 2 3 4 5

1 -> 1
2 -> 1
3 -> 1
4 -> 1
5 -> 1

1 1
1 2
1 3
1 4
1 5
2 2
2 3
2 4
2 5
3 3
3 4
3 5
4 4
4 5
5 5

1 -> 1
2 -> 2
3 -> 3
4 -> 4
5 -> 5


1 1 1 1
..
1 1 1 5 
1 1 2 2
..
1 1 2 5
1 1 3 3
..
1 1 3 5
1 1 4
1 1 5
1 2 2
1 2 3
1 2 4
1 2 5
1 3 3
1 3 4
1 3 5
1 4 4
1 4 5
1 5 5
2 2 2
2 2 3
2 2 4
2 2 5
2 3 3
2 3 4
2 3 5
2 4 4
2 4 5
2 5 5
3 3 3
3 3 4
3 3 5
3 4 4
3 4 5
3 5 5
4 4 4
4 4 5
4 5 5
5 5 5
// 35
1 -> 1
2 -> 2 + 1
3 -> 3 + 2 + 1
4 -> 4 + 3 + 2 + 1
5 -> 5 + 4 + 3 + 2 + 1


    1                               2                           3                   4           5
    1                               1                           1                   1           1
    5                               4                           3                   2           1 1x
   (1..5)                           (1..4)                      (1..3)              (1..2)      1 5x1 4x2 3x3 2x4 1x5
 ((1..5)(1..4)(1..3)(1..2)1)        ((1..4)(1..3)(1..2)1)       ((1..3)(1..2)1)     ((1..2)1)   1 15x1 10x2 3x6 3x4 1x5

 35 +

0 - 1x1     1x2     1x3     1x4 1x5     => 5
1 - 5x1     4x2     3x3     2x4 1x5     => 15
2 - 15x1    10x2    6x3     3x4 1x5     => 35
3 - 35x1    20x2    10x3    4x4 1x5     => 70 // 70 // 126
4 - 70x1    35x2    15x3    5x4 1x5     => 126
*/
