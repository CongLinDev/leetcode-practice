import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, 0, target, new LinkedList<>());
        return result;
    }


    private void combinationSum(int[] candidates, int index, int target, LinkedList<Integer> cache) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(cache));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            cache.addLast(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], cache);
            cache.removeLast();
        }
    }
}
// @lc code=end

