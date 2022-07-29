package com.codemanl.leetcode.editor.cn;
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 167 👎 0

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();

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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode preHead = new ListNode(-1); // 创建一个哨兵节点 用来最后返回首节点
            ListNode prev = preHead; // 创建一个移动的指针
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            prev.next = l1 == null ? l2 : l1;
            return preHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}