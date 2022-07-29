/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (match(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean match(char[][] board, String word, int wordIndex, int i, int j, boolean[][] visited) {
        if (word.length() == wordIndex) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }
        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result = match(board, word, wordIndex + 1, i - 1, j, visited)
            || match(board, word, wordIndex + 1, i, j - 1, visited)
            || match(board, word, wordIndex + 1, i + 1, j, visited)
            || match(board, word, wordIndex + 1, i, j + 1, visited);
        visited[i][j] = false;
        return result;
    }
}
// @lc code=end

