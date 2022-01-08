package array_linked_list.two_pointers.binary_search;

class Solution34_iteration {
    // recursion version
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findLeftRange(nums, target, 0, nums.length), findRightRange(nums, target, 0, nums.length)};
    }

    private int findLeftRange(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findRightRange(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        left = left - 1;
        if (left < 0 || nums[left] != target) {
            return -1;
        }
        return left;
    }
}