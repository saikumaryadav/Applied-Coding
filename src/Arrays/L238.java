package Arrays;

import java.util.Arrays;

/**   238. Product of Array Except Self

 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * */
public class L238 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelfOptimized(array)));
    }

    // its TC :O(n) SC: O(2n)
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int l = 1;
        for( int i=0;i<nums.length;i++){
            leftProduct[i] = l;
            l = l* nums[i];
        }

        int r = 1;
        for( int i=nums.length-1;i>=0;i--){
            rightProduct[i] = r;
            r = r* nums[i];
        }
        for(int i=0;i< nums.length;i++){
            nums[i] = leftProduct[i]* rightProduct[i];
        }
        return nums;
    }


    //TC:O(n) SC: O(n)
    public static int[] productExceptSelfOptimized(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        for( int i=0;i<nums.length;i++){
            result[i] = left;
            left = left* nums[i];
        }
        int right =1;
        for( int i=nums.length-1; i>= 0 ;i--){
            result[i] = result[i] * right;
            System.out.println(result[i]);
            right = right * nums[i];
        }

        return result;
    }

}
