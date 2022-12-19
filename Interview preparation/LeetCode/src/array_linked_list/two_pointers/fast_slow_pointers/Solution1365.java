package array_linked_list.two_pointers.fast_slow_pointers;

import java.util.*;

// 1365. How Many Numbers Are Smaller Than the Current Number
public class Solution1365 {
    private class Pair {
        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int index;
        public int value;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        Pair[] list = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            list[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(list, (o1, o2) -> {
            return o1.value - o2.value;
        });

        for(int low = 0, fast = 0; fast < nums.length; fast++){
            while(list[low].value != list[fast].value){
                low++;
            }
            res[list[fast].index] = low;
        }

        return res;
    }
}

class Solution1365_2 {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            List<Integer> list = map.get(value);
            if (list == null){
                list = new ArrayList<>();
                map.put(value, list);
            }
            list.add(i);
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length;){
            int value = nums[i];
            List<Integer> list = map.get(value);
            for(int index : list){
                res[index] = i;
            }

            i++;
            while(i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
        }

        return res;
    }
}