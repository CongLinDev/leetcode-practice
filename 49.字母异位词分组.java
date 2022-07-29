import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<Integer, List<String>> map = new HashMap<>();
        // List<List<String>> result = new ArrayList<>();
        // for (String str : strs) {
        //     int value = 0;
        //     for (int i = 0; i < str.length(); i++) {
        //         int index = str.charAt(i) - 'a';
        //         value |= 1 << index;
        //     }

        //     List<String> list = map.get(value);
        //     if (list == null) {
        //         list = new ArrayList<>();
        //         list.add(str);
        //         map.put(value, list);
        //         result.add(list);
        //     } else {
        //         list.add(str);
        //     }
        // }
        // return result;
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

