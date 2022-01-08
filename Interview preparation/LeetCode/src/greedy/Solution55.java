package greedy;

class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // ���ϼ�������������Զ����
            farthest = Math.max(farthest, i + nums[i]);
            // ���������� 0����ס��������
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}