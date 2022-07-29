import java.util.Map;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private final Map<TreeNode, Node> cache = new HashMap<>();
    public int rob(TreeNode root) {
        return rob(root, false);
    }

    public int rob(TreeNode root, boolean mustNotUse) {
        if (root == null) return 0;
        Node cacheNode = cache.get(root);
        if (cacheNode != null) {
            if (mustNotUse) {
                if (cacheNode.v1 >= 0) 
                    return cacheNode.v1;
            } else {
                if (cacheNode.v2 >= 0) 
                    return cacheNode.v2;
            }
        } else {
            cacheNode = new Node();
            cache.put(root, cacheNode);
        }

        if (mustNotUse) {
            return rob(root.left, false) + rob(root.right, false);
        }
        // 可以使用
        // 第一种情况 使用
        int s1 = root.val + rob(root.left, true) + rob(root.right, true);
        // 第二种情况 不使用
        int s2 = rob(root.left, false) + rob(root.right, false);
        int result = Math.max(s1, s2);
        if (mustNotUse) {
            cacheNode.v1 = result;
        } else {
            cacheNode.v2 = result;
        }
        return result;
    }

    public static class Node {
        private int v1 = -1;
        private int v2 = -1;
    }
}
// @lc code=end

