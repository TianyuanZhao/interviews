/*
 * @lc app=leetcode id=232 lang=java
 * @lcpr version=30104
 *
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (67.82%)
 * Likes:    8019
 * Dislikes: 459
 * Total Accepted:    1.1M
 * Total Submissions: 1.7M
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The
 * implemented queue should support all the functions of a normal queue (push,
 * peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 * 
 * 
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns
 * it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * 
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a stack, which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may
 * simulate a stack using a list or deque (double-ended queue) as long as you
 * use only a stack's standard operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * 
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 * 
 * 
 * 
 * Follow-up: Can you implement the queue such that each operation is amortized
 * O(1) time complexity? In other words, performing n operations will take
 * overall O(n) time even if one of those operations may take longer.
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class ImplementQueueUsingStacks {

    // @lc code=start
    class MyQueue {
        Deque<Integer> tempStack;
        Deque<Integer> myQueue;
    
        public MyQueue() {
            tempStack = new ArrayDeque<>();
            myQueue = new ArrayDeque<>();
        }
        
        public void push(int x) {
            while (!myQueue.isEmpty()) {
                Integer num = myQueue.pop();
                tempStack.push(num);
            }
    
            myQueue.push(x);
            while (!tempStack.isEmpty()) {
                Integer num = tempStack.pop();
                myQueue.push(num);
            }
        }
        
        public int pop() {
            return myQueue.pop();
        }
        
        public int peek() {
            return myQueue.peek();
        }
        
        public boolean empty() {
            return myQueue.isEmpty();
        }
    }
    
    class Solution {

    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ImplementQueueUsingStacks().new Solution();
        // put your test code here
        
    }
}



// labuladong solution - better time complexity
// class MyQueue {
//     private Stack<Integer> s1, s2;
    
//     public MyQueue() {
//         s1 = new Stack<>();
//         s2 = new Stack<>();
//     }

//     // 添加元素到队尾
//     public void push(int x) {
//         s1.push(x);
//     }
    
//     // 返回队头元素
//     public int peek() {
//         if (s2.isEmpty())
//             // 把 s1 元素压入 s2
//             while (!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }
//         return s2.peek();
//     }

//     // 删除队头元素并返回
//     public int pop() {
//         // 先调用 peek 保证 s2 非空
//         peek();
//         return s2.pop();
//     }

//      // 判断队列是否为空
//      // 两个栈都为空才说明队列为空
//     public boolean empty() {
//         return s1.isEmpty() && s2.isEmpty();
//     }
// }
