/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 2;
        for ( ; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }
        if (index >= 0) {
            int anotherIndex = len - 1;
            for (; anotherIndex > index; anotherIndex--) {
                if (nums[anotherIndex] > nums[index]) {
                    break;
                }
            }
            int temp = nums[anotherIndex];
            nums[anotherIndex] = nums[index];
            nums[index] = temp;
        }
        int left = index + 1;
        int right = len - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end

