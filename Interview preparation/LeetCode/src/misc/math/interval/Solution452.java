package misc.math.interval;

import java.util.Arrays;

// 452. Minimum Number of Arrows to Burst Balloons
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        int res = 0;
        Arrays.sort(points, (int[] o1, int[] o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]){
                return 1;
            } else {
                return 0;
            }
        });

        for(int i = 0; i < points.length;){
            res++;
            int[] point = points[i];
            int end = point[1];
            for(; i < points.length; i++){
                int[] nextPoint = points[i];
                if (end < nextPoint[0]){
                    break;
                }
            }
        }

        return res;
    }
}