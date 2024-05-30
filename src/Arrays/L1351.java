package Arrays;
/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 *
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * **/
public class L1351 {
    public static void main(String[] args) {
        int[][] array = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(array));
    }
    public static int countNegatives(int[][] grid) {
        int row = grid.length-1;
        int col = 0;
        int count = 0;
        int numberOfColumns = grid[0].length;
        while(row >=0 && col <=grid[0].length-1){
            if(grid[row][col] < 0){
                count += numberOfColumns - col;
                row--;
            }else{
                col++;
            }
        }
        return  count;
    }
}
