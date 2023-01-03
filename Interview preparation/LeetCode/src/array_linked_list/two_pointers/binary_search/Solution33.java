package array_linked_list.two_pointers.binary_search;

// 33. Search in Rotated Sorted Array
public class Solution33 {
    public int search(int[] nums, int target) {
        int leftMin = nums[0];
        int rightMax = nums[nums.length - 1];
        if(target == leftMin){
            return 0;
        } else if (target == rightMax){
            return nums.length - 1;
        } else if (target < leftMin && target > rightMax){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(target > nums[middle]) {
                if(nums[middle] <= rightMax){
                    if(target <= rightMax){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if(target > rightMax){
                        left = middle + 1;
                    } else {
                        return -1;
                    }
                }
            } else if (target == nums[middle]){
                return middle;
            } else if (target < nums[middle]){
                if(nums[middle] <= rightMax){
                    if(target <= rightMax){
                        right= middle - 1;
                    } else {
                        return -1;
                    }
                } else {
                    if(target > rightMax){
                        right = middle -1;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }

        return -1;
    }
}
