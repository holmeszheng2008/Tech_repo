package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

       /* Solution391 inst = new Solution391();

        inst.isRectangleCover(new int[][] {
                {1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
        });*/

        Set<int[]> set = new HashSet<>();
        int[] a = new int[]{1,2};
        int[] b = new int[]{1,2};

        set.add(a);
        System.out.println(a.equals(b));
        System.out.println(Arrays.equals(a, b));

    }
}