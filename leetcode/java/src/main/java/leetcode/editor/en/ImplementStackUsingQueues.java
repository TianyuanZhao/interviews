/*
 * @lc app=leetcode id=225 lang=java
 * @lcpr version=30104
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (66.68%)
 * Likes:    6398
 * Dislikes: 1243
 * Total Accepted:    859.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * 
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * 
 * 
 * 
 * Follow-up: Can you implement the stack using only one queue?
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class ImplementStackUsingQueues {

    // @lc code=start
    class MyStack {
        private Deque<Integer> q1, q2;

        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }
        
        public void push(int x) {
            q2.add(x);
        }
        
        public int pop() {
            top();
            return q2.poll();
        }
        
        public int top() {
            if (q2.isEmpty()) {
                while (!q1.isEmpty()) {
                    q2.add(q1.poll());
                }
            }
    
            while (q2.size() > 1) {
                q1.add(q2.poll());
            }
    
            return q2.peek();
        }
        
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public class Solution {

    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ImplementStackUsingQueues().new Solution();
        // put your test code here
        
    }
}



// labuladong solution - better time complexity
// class MyStack {
//     Queue<Integer> q = new LinkedList<>();
//     int top_elem = 0;

//     // 添加元素到栈顶
//     public void push(int x) {
//         q.offer(x);
//         top_elem = x;
//     }
    
//     // 删除栈顶的元素并返回
//     public int pop() {
//         int size = q.size();
//         while (size > 2) {
//             q.offer(q.poll());
//             size--;
//         }
//         top_elem = q.peek();
//         q.offer(q.poll());
//         return q.poll();
//     }
    
//     // 返回栈顶元素
//     public int top() {
//         return top_elem;
//     }
    
//     // 判断栈是否为空
//     public boolean empty() {
//         return q.isEmpty();
//     }
// }
