/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 倒着挑
        int step = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= step) {
                step = 1;
            } else {
                step++;
            }
        }
        return step == 1;
    }
}
// @lc code=end

