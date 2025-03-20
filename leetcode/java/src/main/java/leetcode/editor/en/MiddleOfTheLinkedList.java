/*
 * @lc app=leetcode id=876 lang=java
 * @lcpr version=30104
 *
 * [876] Middle of the Linked List
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * algorithms
 * Easy (80.18%)
 * Likes:    12272
 * Dislikes: 396
 * Total Accepted:    2.4M
 * Total Submissions: 2.9M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * 
 * Example 2:
 * 
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we
 * return the second one.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * 
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) fast = fast.next;
            }
    
            return slow;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

 */

//  class Solution {
//     public ListNode middleNode(ListNode head) {
//         // 快慢指针初始化指向 head
//         ListNode slow = head, fast = head;
//         // 快指针走到末尾时停止
//         while (fast != null && fast.next != null) {
//             // 慢指针走一步，快指针走两步
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         // 慢指针指向中点
//         return slow;
//     }
// }