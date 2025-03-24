/*
 * @lc app=leetcode id=26 lang=java
 * @lcpr version=30104
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (59.62%)
 * Likes:    16357
 * Dislikes: 19623
 * Total Accepted:    5.9M
 * Total Submissions: 9.9M
 * Testcase Example:  '[1,1,2]'
 *
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to do the following things:
 * 
 * 
 * Change the array nums such that the first k elements of nums contain the
 * unique elements in the order they were present in nums initially. The
 * remaining elements of nums are not important as well as the size of
 * nums.
 * Return k.
 * 
 * 
 * Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * 
 * int k = removeDuplicates(nums); // Calls your implementation
 * 
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * ⁠   assert nums[i] == expectedNums[i];
 * }
 * 
 * 
 * If all assertions pass, then your solution will be accepted.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 * 
 * 
 */

package leetcode.editor.en;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    // @lc code=start
    class Solution {
        public int removeDuplicates(int[] nums) {
            int pivot = -999;
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != pivot) {
                    nums[k] = nums[i];
                    pivot = nums[i];
                    k++;
                }
            }

            return k;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,2,2,3,3,4]\n
// @lcpr case=end

 */

//  class Solution {
//     public int removeDuplicates(int[] nums) {
//         if (nums.length == 0) {
//             return 0;
//         }
//         int slow = 0, fast = 0;
//         while (fast < nums.length) {
//             if (nums[fast] != nums[slow]) {
//                 slow++;
//                 // 维护 nums[0..slow] 无重复
//                 nums[slow] = nums[fast];
//             }
//             fast++;
//         }
//         // 数组长度为索引 + 1
//         return slow + 1;
//     }
// }
