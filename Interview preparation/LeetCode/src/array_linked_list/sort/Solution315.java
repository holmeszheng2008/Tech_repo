package array_linked_list.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 315. Count of Smaller Numbers After Self
public class Solution315 {
    private Pair[] temp;
    private int[] count;

    private class Pair {
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        int val;
        int index;
    }
    public List<Integer> countSmaller(int[] nums) {
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] numsPair = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsPair[i] = new Pair(nums[i], i);
        }
        mergeSort(numsPair, 0, nums.length - 1);

        return IntStream.of(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(Pair[] numsPair, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(numsPair, low, mid);
        mergeSort(numsPair, mid + 1, high);

        merge(numsPair, low, mid, high);
    }

    private void merge(Pair[] numsPair, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = numsPair[i];
        }
        int end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (end <= high) {
                if (temp[end].val >= temp[i].val) {
                    break;
                }
                end++;
            }
            count[temp[i].index] += end - mid - 1;
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                numsPair[k] = temp[j++];
            } else if (j == high + 1) {
                numsPair[k] = temp[i++];
            } else if (temp[i].val <= temp[j].val) {
                numsPair[k] = temp[i++];
            } else {
                numsPair[k] = temp[j++];
            }
        }
    }
}
