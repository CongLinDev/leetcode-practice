import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] cache = new boolean[21];
        for (int num : nums) {
            cache[num + 10] = true;
        }

        dfs(cache, 0, new LinkedList<>());
        result.add(Collections.emptyList());
        return result;
    }

    private void dfs(boolean[] cache, int index, LinkedList<Integer> list) {
        if (index == cache.length) {
            if (!list.isEmpty())
                result.add(new ArrayList<>(list));
            return;
        }
        dfs(cache, index + 1, list);
        if (cache[index]) {
            list.addLast(index - 10);
            dfs(cache, index + 1, list);
            list.removeLast();
        }
    }
}
// @lc code=end

