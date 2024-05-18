package Arrays;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 * 1299. Replace Elements with Greatest Element on Right Side
 * Easy
 * Topics
 * Companies
 * Hint
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * */
public class L1299 {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
    public static int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = -1;
        for(int i= arr.length-1 ; i>=0;i--){
            res[i] = max;
            max = Math.max(max, arr[i]);
        }
        //  System.out.println(Arrays.toString(res));
        return res;
    }
}

