/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len + 1];
        int[] right = new int[len + 1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }

        int result = 0;
        for (int i = 0; i < len; i ++) {
            result += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return result;

    }
}
// @lc code=end

