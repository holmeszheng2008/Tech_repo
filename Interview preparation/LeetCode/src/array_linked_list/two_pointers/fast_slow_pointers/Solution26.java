package array_linked_list.two_pointers.fast_slow_pointers;

// 26. Remove Duplicates from Sorted Array
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            nums[slow] = nums[fast];
            slow++;
            fast++;
            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
       }

       return slow;
    }
}