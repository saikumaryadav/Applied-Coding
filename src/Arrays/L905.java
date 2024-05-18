package Arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * */
public class L905 {
    public static void main(String[] args) {
        int[] array = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(array)));
    }

    //by using 2 pointer approach
    //TC: just one O(n) , SC: O(1)
    public static int[] sortArrayByParity(int[] nums) {
        int i= 0;
        int j = nums.length-1;
        int temp = 0;
        while(i<j){
            if(nums[i] %2 != 0){
                temp = nums[i];
                nums[i] =nums[j];
                nums[j] = temp;
                j--;
            }else{
                i++;
            }
        }
        return nums;
    }
}
