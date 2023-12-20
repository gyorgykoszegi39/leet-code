public class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = 100, min2 = 100;

        for(int price: prices) {
            if(min1 > price) {
                min2 = min1;
                min1 = price;
            } else if(min2 > price)
                min2 = price;
        }

        return money < min1 + min2 ? money : money - (min1 + min2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.buyChoco(new int[] {1, 2, 2}, 3));
        System.out.println(s.buyChoco(new int[] {3, 2, 3}, 3));
    }
}
