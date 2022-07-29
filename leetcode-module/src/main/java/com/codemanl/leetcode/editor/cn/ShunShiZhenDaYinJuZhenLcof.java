package com.codemanl.leetcode.editor.cn;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 302 👎 0

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();

        int[][] entity = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = solution.spiralOrder(entity);
        System.out.println(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {


            if (matrix.length == 0) {
                return new int[]{};
            }
            int rows = matrix.length;
            int columns = matrix[0].length;
            int size = columns * rows; // 数组的容量
            int[] res = new int[size]; // 返回的数组
            int[] yDirection = new int[]{1, 0, -1, 0};
            int[] xDirection = new int[]{0, 1, 0, -1};
            boolean[][] visited = new boolean[rows][columns];
            int row = 0;
            int column = 0;
            int directionIndex = 0;
            for (int i = 0; i < size; i++) {

                res[i] = matrix[row][column];
                visited[row][column] = true; // 说明走过了
                int nextXPos = row + xDirection[directionIndex];
                int nextYPos = column + yDirection[directionIndex];
                if (nextXPos >= rows || nextYPos >= columns || nextXPos < 0 || nextYPos < 0 || visited[nextXPos][nextYPos]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += xDirection[directionIndex];
                column += yDirection[directionIndex]; // 下一个
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}