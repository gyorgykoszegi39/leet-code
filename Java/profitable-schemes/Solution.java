
public class Solution {

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int len = group.length;
        int[][] profitTable = new int [n + 1][minProfit + 1];
        profitTable[0][0] = 1;
        for(int i = 0; i < len; i++) {
            int gr =  group[i];
            int pr = profit[i];

            for(int j = n; j >= gr; j--) {
                for(int k = minProfit; k >= 0; k--) {
                    profitTable[j][k] = (profitTable[j][k] + profitTable[j - gr][Math.max(0, k - pr)]) % 1000000007;
                }
            }
        }

        int result = 0;
        for(int i = 0; i <= n; i++) {
            result = (result + profitTable[i][minProfit]) % 1000000007;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        System.out.println(Solution.profitableSchemes(10, 5, group, profit));
    }
}
