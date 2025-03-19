class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 1) {
                continue;
            }
            for (int j = i; j < i + 3; j++) {// window
                nums[j] ^= 1;
            }
            ans++;
        }
        if (nums[n-1] != 1 || nums[n-2] != 1)
            return -1;
        return ans;
    }
}