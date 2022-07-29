/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, 
        int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
    
        // 前序遍历中的第一个节点就是根节点
        int rootVal = preorder[preorderLeft];
        int inorderIndex = findIndex(rootVal, inorder, inorderLeft, inorderRight);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(rootVal);
        int leftSubTreeSize = inorderIndex - inorderLeft;
        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubTreeSize, inorderLeft, inorderIndex - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + leftSubTreeSize + 1, preorderRight, inorderIndex + 1, inorderRight);
        return root;
    }

    private int findIndex(int target, int[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

