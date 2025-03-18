/*
 * @lc app=leetcode id=23 lang=java
 * @lcpr version=30103
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (55.91%)
 * Likes:    20152
 * Dislikes: 745
 * Total Accepted:    2.4M
 * Total Submissions: 4.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), p = dummy;
        Comparator<ListNode> nodeComparator = new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<>(10^4, nodeComparator);
        for (ListNode list : lists) {
            while(list != null) {
                ListNode temp = list.next;
                list.next = null;
                queue.add(list);
                list = temp;
            }
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
        }

        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */

//  class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0) return null;
//         // 虚拟头结点
//         ListNode dummy = new ListNode(-1);
//         ListNode p = dummy;
//         // 优先级队列，最小堆
//         PriorityQueue<ListNode> pq = new PriorityQueue<>(
//             lists.length, (a, b)->(a.val - b.val));
//         // 将 k 个链表的头结点加入最小堆
//         for (ListNode head : lists) {
//             if (head != null) {
//                 pq.add(head);
//             }
//         }

//         while (!pq.isEmpty()) {
//             // 获取最小节点，接到结果链表中
//             ListNode node = pq.poll();
//             p.next = node;
//             if (node.next != null) {
//                 pq.add(node.next);
//             }
//             // p 指针不断前进
//             p = p.next;
//         }
//         return dummy.next;
//     }
// }
