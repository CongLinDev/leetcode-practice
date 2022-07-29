
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new boolean[s.length()], 0);
    }
    public boolean dfs(String s, Set<String> wordDict, boolean[] sign, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            if (sign[i]) {
                continue;
            }
            if (wordDict.contains(s.substring(start, i + 1))) {
                if (dfs(s, wordDict, sign, i + 1)) {
                    return true;
                }
                sign[i] = true;
            }
        }
        return false;
    }
}
// @lc code=end

