import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            arr[i] += 10001 * count1bits(arr[i]);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
            arr[i] %= 10001;
            
        return arr;
    }

    public int[] sortByBits1(int[] arr) {
        int key;
        TreeMap <Integer, ArrayList<Integer>> numbers = new TreeMap<>();
        ArrayList<Integer> arrayList;
        for(int i = 0; i < arr.length; i++) {
            key = count1bits(arr[i]);
            arrayList = numbers.getOrDefault(key, new ArrayList<Integer>());
            arrayList.add(arr[i]);
            numbers.put(key, arrayList);
        }
        int j = 0;
        for(Integer k : numbers.keySet()) {
            arrayList = numbers.get(k);
            Collections.sort(arrayList);
            for(Integer number : arrayList) {
                arr[j++] = number;
            }
            
        }
        return arr;
    }

    private int count1bits(int number) {
        int bits = 0;

        while(number != 0) {
            bits += number & 1;
            number = number >>> 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int number : s.sortByBits(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 })) {
            System.out.println(number);
        }
        for(int number : s.sortByBits(new int[] { 1024, 512, 256, 128, 64, 8, 4, 2, 1 })) {
            System.out.println(number);
        }
        for(int number : s.sortByBits1(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 })) {
            System.out.println(number);
        }
        for(int number : s.sortByBits1(new int[] { 1024, 512, 256, 128, 64, 8, 4, 2, 1 })) {
            System.out.println(number);
        }
    }
}
