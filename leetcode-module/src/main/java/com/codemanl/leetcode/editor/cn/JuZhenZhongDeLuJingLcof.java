package com.codemanl.leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 数组 回溯 矩阵 👍 419 👎 0

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        solution.exist(board, word);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean res = false; // 最终结果
        int length; // word 的长度，dfs方法中要用
        char[][] b; // 传入的二维数组，dfs方法中要用
        char[] w; // word本身
        int bx, by; // bx board的x轴坐标   by board的y轴坐标
        boolean[][] flag; // 用来标识节点是否在本次dfs中使用过，如果使用过，则直接跳过, 走过的为true,没有走过的为false

        public boolean exist(char[][] board, String word) {
            bx = board.length;
            by = board[0].length;
            length = word.length();
            b = board;
            w = word.toCharArray();
            flag = new boolean[bx][by];


            for (int i = 0; i < bx; i++) {
                for (int j = 0; j < by; j++) {
                    if (w[0] == board[i][j]) { // 找到第一个字符
                        flag[i][j] = true; // 将走过的节点坐标对应标记改为true
                        dfs(1, i, j); // 进行dfs
                        flag[i][j] = false; // dfs结束后将标记改回false,下次还可以继续使用
                    }
                    if (res) { // 每次遍历（不是dfs）之后，判断是否已经找到
                        return true;
                    }
                }
            }
            return res;

        }

        /**
         * @param dept 深度
         * @param i    当前节点的x轴坐标
         * @param j    当前节点的y轴坐标
         * @return
         */
        private void dfs(int dept, int i, int j) {
            if (dept == length || res) { // 深度等于word的长度,说明走完了最后一步  "|| res "用来判断如果已经得出res=true的结果时
                res = true;
                return;
            }
            int[] dx = new int[]{0, 0, -1, 1}; // 方向数组
            int[] dy = new int[]{1, -1, 0, 0};

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k]; // 下一步要走的节点x坐标
                int y = j + dy[k]; // 下一步要走的节点y坐标

                if (x < 0 || y < 0 || x >= bx || y >= by || flag[x][y]) {  // 如果数组的下标越界或者当前节点已经使用过,则跳过本次循环
                    continue;
                }

                if (b[x][y] == w[dept]) { // 如果这个节点是下一个需要的节点，递归调用dfs
                    flag[x][y] = true;
                    dfs(dept + 1, x, y);
                    flag[x][y] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}