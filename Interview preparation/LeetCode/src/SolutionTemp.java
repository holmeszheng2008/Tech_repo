public class SolutionTemp {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxTo = 0;
        for (int[] trip : trips) {
            maxTo = Math.max(maxTo, trip[2]);
        }
        int[] diffArray = new int[maxTo + 2];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            diffArray[from] += passengers;
            diffArray[to] -= passengers;
        }

        int[] nums = new int[maxTo + 1];
        nums[0] = diffArray[0];
        if (nums[0] > capacity) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = diffArray[i] + nums[i - 1];
            if (nums[i] > capacity) {
                return false;
            }
        }

        return true;
    }

}
