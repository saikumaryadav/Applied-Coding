package Arrays;
import java.util.*;

//https://leetcode.com/problems/majority-element/description/

public class MajorityElement {
    public static void main(String[] args) {
        int[] array = {1,2,2,3,4,2,2};
        System.out.println(majorityElement(array));
    }
    //TC : O(n) +O(n)
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else{
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2){
                return key;
            }
        }
        return 0;
    }

    //TC : O(n) +O(1)
    public int boyerMooreAlgorithm(int[] nums) {


        int count = 0;
        int m =0;
        for(int i=0;i<nums.length ; i++){
            if(count == 0){
                m = nums[i];
                count =1;
            } else{
                if(m == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        int c=0;
        for(int i = 0 ;i<nums.length ; i++){
            if(nums[i] == m){
                c++;
            }
        }
        if(c > (nums.length)/2){
            return m;
        }else{
            return 0;
        }
    }
}
