package com.codemanl.leetcode.editor.cn;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 189 👎 0

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
//        int length = 0; // 链表的长度

        public int[] reversePrint(ListNode head) {
            ListNode cur = head;
            int size = 0;
            while (cur != null) {
                size++;
                cur = cur.next;
            }

            int[] res = new int[size];
            size--;
            while (head != null) {
                res[size--] = head.val;
                head = head.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}