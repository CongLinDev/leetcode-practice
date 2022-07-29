import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }

    private void permute(int[] nums, boolean[] visited, LinkedList<Integer> cache) {
        if (cache.size() == nums.length) {
            result.add(new ArrayList<>(cache));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cache.addLast(nums[i]);
                visited[i] = true;
                permute(nums, visited, cache);
                cache.removeLast();
                visited[i] = false;
            }
        }
    }
}
// @lc code=end

