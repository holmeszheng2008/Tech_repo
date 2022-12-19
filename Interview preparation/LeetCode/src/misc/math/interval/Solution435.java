package misc.math.interval;

import java.util.Arrays;

// 435. Non-overlapping Intervals
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            } else {
                return 0;
            }
        });

        for(int i = 0; i < intervals.length;){
            int[] interval  = intervals[i];
            int end = interval[1];
            i++;
            for(; i < intervals.length; i++){
                int[] nextInterval = intervals[i];
                if (end <= nextInterval[0]){
                    break;
                }
                res++;
            }
        }
        return res;
    }
}