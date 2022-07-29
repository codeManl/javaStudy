package com.codemanl.leetcode.editor.cn;
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 566 👎 0

import java.util.HashMap;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int length = inorder.length;
            map = new HashMap<Integer, Integer>();
            for (int i = 0; i < length; i++) {
                map.put(inorder[i], i);
            }

            return recursion(preorder, inorder, 0, length - 1, 0, length - 1);
        }

        /**
         * 递归构建二叉树
         *
         * @param preorder 前序遍历二叉树
         * @param inorder  中序遍历二叉树
         * @param preLeft  前序遍历中的左节点
         * @param preRight 前序遍历中的右节点
         * @param inLeft   中序遍历中的左节点
         * @param inRight  中序遍历中的右节点
         * @return
         */
        private TreeNode recursion(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            int preRoot = preLeft; // 获取根节点在前序遍历中的位置
            int inRoot = map.get(preorder[preRoot]); // 获取根节点在中序遍历中的位置
            TreeNode root = new TreeNode(inorder[inRoot]); // 先构建二叉树并指定当前的根节点
            int inOrder_left_size = inRoot - inLeft; // 获取当前根节点的左边节点数量
            // 构建左子树并连接到根节点
            root.left = recursion(preorder, inorder, preLeft + 1, preLeft + inOrder_left_size, inLeft, inRoot - 1);
            // 构建右子树
            root.right = recursion(preorder, inorder, preLeft + inOrder_left_size + 1, preRight, inRoot + 1, inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}