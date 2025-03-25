/*
 * @lc app=leetcode id=283 lang=java
 * @lcpr version=30104
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (62.59%)
 * Likes:    17686
 * Dislikes: 514
 * Total Accepted:    3.9M
 * Total Submissions: 6.2M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class MoveZeroes {

    // @lc code=start
    class Solution {
        public void moveZeroes(int[] nums) {
            int k = removeElement(nums, 0);
            for (int j = k; k > 0 && j < nums.length; j++) {
                nums[j] = 0;
            }
        }

        public int removeElement(int[] nums, int val) {
            int k = -1;
            if (nums == null) {
                return 0;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    k++;
                    nums[k] = nums[i];
                }
            }

            return k + 1;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

//  class Solution {
//     public void moveZeroes(int[] nums) {
//         // 去除 nums 中的所有 0，返回不含 0 的数组长度
//         int p = removeElement(nums, 0);
//         // 将 nums[p..] 的元素赋值为 0
//         for (; p < nums.length; p++) {
//             nums[p] = 0;
//         }
//     }

//     public int removeElement(int[] nums, int val) {
//         // 见上文代码实现
//     }
// }
