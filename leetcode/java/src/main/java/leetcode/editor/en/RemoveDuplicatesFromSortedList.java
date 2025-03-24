/*
 * @lc app=leetcode id=83 lang=java
 * @lcpr version=30104
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (54.45%)
 * Likes:    9151
 * Dislikes: 333
 * Total Accepted:    1.9M
 * Total Submissions: 3.4M
 * Testcase Example:  '[1,1,2]'
 *
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * 
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedList {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-999);
            dummy.next = head;
            ListNode fast = head, slow = dummy;
            while (fast != null && slow != null) {
                if (fast.val != slow.val) {
                    slow = slow.next;
                    slow.val = fast.val;
                }

                fast = fast.next;
            }
            slow.next = null;
            return dummy.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,3]\n
// @lcpr case=end

 */

//  class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null) return null;
//         ListNode slow = head, fast = head;
//         while (fast != null) {
//             if (fast.val != slow.val) {
//                 // nums[slow] = nums[fast];
//                 slow.next = fast;
//                 // slow++;
//                 slow = slow.next;
//             }
//             // fast++
//             fast = fast.next;
//         }
//         // 断开与后面重复元素的连接
//         slow.next = null;
//         return head;
//     }
// }
