/*
 * @lc app=leetcode id=21 lang=java
 * @lcpr version=30103
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.09%)
 * Likes:    23033
 * Dislikes: 2252
 * Total Accepted:    5M
 * Total Submissions: 7.6M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * Example 1:
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * 
 * Example 2:
 * 
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        if (list1 != null) {
            mergedList.next = list1;
        } else if (list2 != null) {
            mergedList.next = list2;
        }
        
        head = head.next;
        return head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

 */

// Labuladong Solution - two-pointers
// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         // 虚拟头结点
//         ListNode dummy = new ListNode(-1), p = dummy;
//         ListNode p1 = l1, p2 = l2;
        
//         while (p1 != null && p2 != null) {
//             // 比较 p1 和 p2 两个指针
//             // 将值较小的的节点接到 p 指针
//             if (p1.val > p2.val) {
//                 p.next = p2;
//                 p2 = p2.next;
//             } else {
//                 p.next = p1;
//                 p1 = p1.next;
//             }
//             // p 指针不断前进
//             p = p.next;
//         }
        
//         if (p1 != null) {
//             p.next = p1;
//         }
        
//         if (p2 != null) {
//             p.next = p2;
//         }
        
//         return dummy.next;
//     }
// }
