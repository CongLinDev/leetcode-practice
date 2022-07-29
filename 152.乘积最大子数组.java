/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // 偶数个负数
        int len = nums.length;
        int[] maxArray = new int[len];
        int[] minArray = new int[len];
        maxArray[0] = minArray[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxArray[i] = Math.max(nums[i], Math.max(maxArray[i - 1] * nums[i], minArray[i - 1] * nums[i]));
            minArray[i] = Math.min(nums[i], Math.min(maxArray[i - 1] * nums[i], minArray[i - 1] * nums[i]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }
}
// @lc code=end

