import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    class Job {
        private int startTime;
        private int endTime;
        private int profit;

        public Job(int st, int et, int p) {
            startTime = st;
            endTime = et;
            profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length, nextJob;
        int[] dp = new int[n + 1];
        Job[] jobs = new Job[n];

        for(int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        for(int i = 0; i < n; i++) {
            nextJob = binarySearch(jobs, i, jobs[i].startTime);
            dp[i + 1] = Math.max(dp[i], dp[nextJob] + jobs[i].profit);
        }

        return dp[n];
    }

    private int binarySearch(Job[] jobs, int end, int target) {
        int start = 0, mid;

        while(start < end) {
            mid = (start + end) / 2;

            if(jobs[mid].endTime <= target)
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.jobScheduling(new int[] {1, 2, 3, 3}, new int[] {3, 4, 5, 6}, new int[] {50, 10, 40, 70}));
        System.out.println(s.jobScheduling(new int[] {1, 2, 3, 4, 6}, new int[] {3, 5, 10, 6, 9}, new int[] {20, 20, 100, 70, 60}));
        System.out.println(s.jobScheduling(new int[] {1, 1, 1}, new int[] {2, 3, 4}, new int[] {5, 6, 4}));
    }
}
