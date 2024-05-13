package Arrays;
import  java.util.*;
public class rotateArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(a, k);
    }
    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        if(k > n)
        {
            k = k%n;
        }
        reverseArray(nums, n-k, n-1);
        reverseArray(nums, 0, n-k-1);
        reverseArray(nums, 0, n-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void reverseArray(int[] a, int l, int h){
        //int l=start;
        //int h=end;
        int temp = 0;
        while(l < h){
            temp = a[l];
            a[l] = a[h];
            a[h] =temp;
            l++;
            h--;
        }

    }

}
