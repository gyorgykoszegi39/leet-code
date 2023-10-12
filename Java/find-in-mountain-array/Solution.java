import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int findInMountainArray(int target, ArrayList<Integer> mountainArr) {
        int top = findTopOfMountain(mountainArr);
        int searchLeft = binarySearch(mountainArr, 0, top, target, true);
        if(searchLeft == - 1)
            return binarySearch(mountainArr, top, mountainArr.size() - 1, target, false);

        return searchLeft;
    }

    private int findTopOfMountain(ArrayList<Integer> mountainArr) {
        int mid, left = 0, right = mountainArr.size() - 1;
        mid = (left + right) / 2;
        int prev = mountainArr.get(mid - 1);
        int curr = mountainArr.get(mid);
        int next = mountainArr.get(mid + 1);

        while(!(prev < curr && curr > next)) {
            if(prev < next) {
                left = mid;
            } else {
                right = mid;
            }

            mid = (left + right) / 2;
            prev = mountainArr.get(mid - 1);
            curr = mountainArr.get(mid);
            next = mountainArr.get(mid + 1);
        }

        return mid;
    }

    private int binarySearch(ArrayList<Integer> mountainArr, int left, int right, int target, boolean isAsc) {
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(target == mountainArr.get(mid)) {
                return mid;
            } else if(target < mountainArr.get(mid)) {
                if(isAsc)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(isAsc)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findInMountainArray(3, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 3, 1))));
        System.out.println(s.findInMountainArray(3, new ArrayList<Integer>(Arrays.asList(0, 1, 2, 4, 3, 2, 1))));
        System.out.println(s.findInMountainArray(2, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 3, 1))));
        System.out.println(s.findInMountainArray(0, new ArrayList<Integer>(Arrays.asList(3, 5, 3, 2, 0))));

    }
}
