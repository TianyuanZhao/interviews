/*
 * @lc app=leetcode id=234 lang=java
 * @lcpr version=30104
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (55.28%)
 * Likes:    17194
 * Dislikes: 920
 * Total Accepted:    2.3M
 * Total Submissions: 4.2M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class PalindromeLinkedList {

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
        // 从左向右移动的指针
        ListNode left;
        // 从右向左移动的指针
        ListNode right;

        // 记录链表是否为回文
        boolean res = true;

        public boolean isPalindrome(ListNode head) {
            left = head;
            traverse(head);
            return res;
        }

        void traverse(ListNode right) {
            if (right == null) {
                return;
            }

            // 利用递归，走到链表尾部
            traverse(right.next);

            // 后序遍历位置，此时的 right 指针指向链表右侧尾部
            // 所以可以和 left 指针比较，判断是否是回文链表
            if (left.val != right.val) {
                res = false;
            }
            left = left.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

// labuladong solution - space complexity O(1)
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode slow, fast;
//         slow = fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         if (fast != null)
//             slow = slow.next;
        
//         ListNode left = head;
//         ListNode right = reverse(slow);
//         while (right != null) {
//             if (left.val != right.val)
//                 return false;
//             left = left.next;
//             right = right.next;
//         }
        
//         return true;
//     }

//     ListNode reverse(ListNode head) {
//         ListNode pre = null, cur = head;
//         while (cur != null) {
//             ListNode next = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = next;
//         }
//         return pre;
//     }
// }
