package Arrays;

import java.util.Stack;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 * Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * */
public class L581 {

    public static void main(String[] args) {
        int[] array = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(array));
        System.out.println(findUnsortedSubarrayOptimized1(array));
    }
    //TC: O(n2)
    public static int findUnsortedSubarray(int[] nums) {
        int size = nums.length;
        int start = size;
        int end = 0;
        for( int i=0;i< size-1;i++){
            for(int j = i+1;j<size;j++){
                if(nums[i]>nums[j]){
                    start = Math.min(start, i);
                    end = Math.max(end,j);
                }
            }
        }
        // System.out.println(start);
        //System.out.println(end);
        if(start == size && end ==0){
            return 0;
        }
        return end- start +1;
    }
    public static int findUnsortedSubarrayOptimized1(int[] nums) {

        Stack<Integer> s =new Stack<>();
        int start = nums.length;
        //Input: nums = [2,6,4,8,10,9,15]

        for(int i=0;i< nums.length;i++){
            while(!s.empty() && nums[s.peek()] > nums[i]){
                //System.out.println("true");
                start = Math.min( start, s.pop());
            }
            s.push(i);
        }
      //  System.out.println(start);

        s.clear();
        int end = 0;
        for(int i= nums.length-1 ; i>=0;i--){
            while(!s.empty() && nums[s.peek()]<nums[i]){
                end = Math.max(end, s.pop() );
            }
            s.push(i);
        }
        //System.out.println(start);
        //System.out.println(end);
        if(start == nums.length && end ==0){
            return 0;
        }
        return end- start +1;

    }


}
