/*
 * @lc app=leetcode id=344 lang=java
 * @lcpr version=30104
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (79.57%)
 * Likes:    8923
 * Dislikes: 1191
 * Total Accepted:    3.1M
 * Total Submissions: 3.9M
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 * 
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseString {

    // @lc code=start
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char ch = s[left];
                s[left] = s[right];
                s[right] = ch;
                left++;
                right--;
            }
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// ["h","e","l","l","o"]\n
// @lcpr case=end

// @lcpr case=start
// ["H","a","n","n","a","h"]\n
// @lcpr case=end

 */

//  void reverseString(char[] s) {
//     // 一左一右两个指针相向而行
//     int left = 0, right = s.length - 1;
//     while (left < right) {
//         // 交换 s[left] 和 s[right]
//         char temp = s[left];
//         s[left] = s[right];
//         s[right] = temp;
//         left++;
//         right--;
//     }
// }
