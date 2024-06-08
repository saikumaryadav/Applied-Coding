package Arrays;

import java.util.Arrays;

/**
 * 41. First Missing Positive
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 */
public class L41 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(firstMissingPositiveOptimized(arr));

       // System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                result += 1;
            }
        }
        return result;
    }

    public static int firstMissingPositiveOptimized(int[] nums) {
        int size = nums.length;
        boolean isExist = false;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 1) {
                isExist = true;
            }
        }
        if (isExist == false) {
            return 1;
        }
        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0 || nums[i] > (size)) {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < size; i++) {
            int value = Math.abs(nums[i]);
            if (value == size) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[value] = Math.abs(nums[value]) * -1;
            }

            /**if( size >1 && nums[Math.abs(nums[i])] >0){
             nums[Math.abs(nums[i])] = Math.abs(nums[Math.abs(nums[i])]) * -1;
             }**/
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 1; i < size; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return size;
        }
        return size + 1;
    }

}
