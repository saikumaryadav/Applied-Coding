package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 * 496. Next Greater Element I
 * Solved
 * Easy
 * Topics
 * Companies
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * **/
public class L496 {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums2.length;i++){
            if(stack.isEmpty()){
                stack.push(nums2[i]);
            }else{
                if(  stack.peek() < nums2[i]){
                    while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                        int value = stack.pop();
                        map.put(value, nums2[i]);
                    }
                    stack.push(nums2[i]);
                }else{
                    stack.push(nums2[i]);
                }
            }
        }
        System.out.println("map is "+map);

        for(int i=0;i< nums1.length;i++){
            result[i] = map.containsKey(nums1[i])==true ? map.get(nums1[i]): -1;
        }
        return result;
    }
}
