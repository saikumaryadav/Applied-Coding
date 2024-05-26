package Arrays;

import java.util.*;
/**
 *  1389. Create Target Array in the Given Order
 *
 *Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 *     Initially target array is empty.
 *     From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 *     Repeat the previous step until there are no elements to read in nums and index.
 *
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 *
 *
 * */
public class L1389 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(index[i],nums[i]);
        }
        int[] res = new int[list.size()];
        for(int i =0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
