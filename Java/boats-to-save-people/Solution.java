import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        int[] sortedPeople = new int[limit + 1];
        
        for(int p : people )
            sortedPeople[p]++;

        int i = 0, j = sortedPeople.length - 1, result = 0;
        while(i <= j) {
            while(i <= j && sortedPeople[i] == 0 )
                i++;
            while(i <= j && sortedPeople[j] == 0 )
                j--;

            if(sortedPeople[i] <= 0 && sortedPeople[j] <= 0)
                break;

            result++;
            if(i + j <= limit)
                sortedPeople[i]--;
            
            sortedPeople[j]--;
        }
        
        return result;
    }

    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int result = people.length;

        int i = 0, j = people.length - 1;
        while(i < j) {
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
                result--;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numRescueBoats(new int[] {1, 2}, 3));
        System.out.println(s.numRescueBoats(new int[] {3, 2, 1, 2}, 3));
        System.out.println(s.numRescueBoats(new int[] {3, 3, 4, 5}, 5));
    }
}
