/*
 * @lc app=leetcode id=19 lang=java
 * @lcpr version=30103
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (48.20%)
 * Likes:    19729
 * Dislikes: 845
 * Total Accepted:    3.3M
 * Total Submissions: 6.9M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        if (p1 == null) {
            return head.next;
        }

        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode nodeNthFromEnd = p2.next;
        p2.next = nodeNthFromEnd.next;

        return head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */

//  class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         // 虚拟头结点
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
//         ListNode x = findFromEnd(dummy, n + 1);
//         // 删掉倒数第 n 个节点
//         x.next = x.next.next;
//         return dummy.next;
//     }
        
//     private ListNode findFromEnd(ListNode head, int k) {
//         // 代码见上文
//     }
// }
