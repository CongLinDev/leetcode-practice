/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(doRob(nums, 0, len - 2), doRob(nums, 1, len - 1));
    }

    private int doRob(int[] nums, int beginIndex, int endIndex) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[beginIndex] = nums[beginIndex];
        dp[beginIndex + 1] = Math.max(nums[beginIndex], nums[beginIndex + 1]);
        for (int i = 2 + beginIndex; i <= endIndex; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[endIndex];
    }
}
// @lc code=end

