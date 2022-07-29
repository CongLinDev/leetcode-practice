import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];
            if (last[0] == current[0]) {
                if (last[1] < current[1]) {
                    last[1] = current[1];
                }
            } else {
                // assert last[0] < current[0]
                if (last[1] < current[0]) {
                    result.add(current);
                } else {
                    last[1] = Math.max(last[1], current[1]);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

