
public class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int result = 0;

        while(mainTank >= 5) {
            result += 50;
            mainTank -= 5;
            if(additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }

        }

        return result + mainTank * 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distanceTraveled(5, 10));
    }
}
