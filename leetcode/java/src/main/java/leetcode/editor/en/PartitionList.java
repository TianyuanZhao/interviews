/*
 * @lc app=leetcode id=86 lang=java
 * @lcpr version=30104
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (58.41%)
 * Likes:    7614
 * Dislikes: 928
 * Total Accepted:    739.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * 
 * 
 * Example 2:
 * 
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * 
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1), p1 = dummy1;
            ListNode dummy2 = new ListNode(-1), p2 = dummy2;
            while (head != null) {
                ListNode temp = new ListNode(head.val);
                if (head.val < x) {
                    p1.next = temp;
                    p1 = p1.next;
                } else {
                    p2.next = temp;
                    p2 = p2.next;
                }
                head = head.next;
            }
    
            p1.next = dummy2.next;
            return dummy1.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,4,3,2,5,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n
// @lcpr case=end

 */

//  class Solution {
//     public ListNode partition(ListNode head, int x) {
//         // 存放小于 x 的链表的虚拟头结点
//         ListNode dummy1 = new ListNode(-1);
//         // 存放大于等于 x 的链表的虚拟头结点
//         ListNode dummy2 = new ListNode(-1);
//         // p1, p2 指针负责生成结果链表
//         ListNode p1 = dummy1, p2 = dummy2;
//         // p 负责遍历原链表，类似合并两个有序链表的逻辑
//         // 这里是将一个链表分解成两个链表
//         ListNode p = head;
//         while (p != null) {
//             if (p.val >= x) {
//                 p2.next = p;
//                 p2 = p2.next;
//             } else {
//                 p1.next = p;
//                 p1 = p1.next;
//             }
//             // 不能直接让 p 指针前进，
//             // p = p.next
//             // 断开原链表中的每个节点的 next 指针
//             ListNode temp = p.next;
//             p.next = null;
//             p = temp;
//         }
//         // 连接两个链表
//         p1.next = dummy2.next;

//         return dummy1.next;
//     }
// }