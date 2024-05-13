package Arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 *
 * */

public class L1365 {
    public static void main(String[] args) {
        int[] array = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(array)));
        System.out.println(Arrays.toString(optimized(array)));
    }
    //1st approach is brutforce - o(n2)


    //2nd approach : sorting the array and store it in hash map with their index as count and create new array and store the hashmap values into their.
    //TC : O(nlogn) SC: O(n)
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = new int[nums.length];
        int[] res = new int[nums.length];
        for(int i=0;i< nums.length; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<temp.length;i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i], i);
            }
        }
        for(int i =0 ;i<nums.length;i++){
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    //3rd approach using 100 sized array and  prefix sum
    //TC:O(n)
    public static int[] optimized(int[] nums){
        // declaired an array with initialization of 100 size as 0's
        int[] array = new int[101];

        // increment the value by 1 in array which occured in nums
        for(int i = 0;i<nums.length;i++){
            array[nums[i]] += 1;
        }

        // do prefix sum to array
        for(int i=1;i<array.length;i++){
            array[i] = array[i] + array[i-1];
        }

        // Now take the previous value of array index to current value of nums array
        for(int i = 0;i<nums.length ;i++){
            if(nums[i] > 0 ){
                nums[i] = array[nums[i] -1];
            }
        }
        System.out.println(Arrays.toString(array));

        return nums;
    }

}
