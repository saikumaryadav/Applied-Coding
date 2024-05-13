package Arrays;
//https://leetcode.com/problems/missing-number/description/
//note: input always starts with 0 in the aray
public class MissingNumber {
    public static void main(String[] args) {
       int[] array = {1,3,4,5,6,7,2,9,0};
        System.out.println(missingNumber(array));

    }

    public static int missingNumber(int[] nums) {
        int totalSum = 0, currentSum = 0;
        for(int i=0 ;i <nums.length ; i++){
            totalSum = totalSum ^ i;
            currentSum = currentSum ^ nums[i];

        }
        totalSum = totalSum ^ nums.length;
        return totalSum ^currentSum;
    }
    //note : ask from where it is starting because we can find starting and last number as missing number

}
