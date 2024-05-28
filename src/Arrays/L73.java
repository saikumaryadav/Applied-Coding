package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * 73. Set Matrix Zeroes
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * */
public class L73 {
    public static void main(String[] args) {
        int[][] array ={{0,1}};// {{0,1,2,0},{3,4,5,2},{1,3,1,5}};//{{1,0,3},{0,5,6},{7,8,9}};
        setZeroesInplace(array);
    }
    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               if(row.contains(i)){
                   matrix[i][j] = 0;
               }
                if(col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public static void setZeroesInplace(int[][] matrix) {
        boolean rowFlag =  false;
        boolean colFlag = false;

        //First making all first row and first columns as 0 when we found the particular place is 0
        for(int i=0;i< matrix.length;i++){
            for( int j=0;j< matrix[i].length; j++){
                if(j==0 && matrix[i][j] == 0){
                    colFlag = true;
                }
                if(i ==0 && matrix[i][j] == 0){
                    rowFlag = true;
                }
                if(matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.println("----");
        for(int[] i : matrix){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("------");
        System.out.println(rowFlag+"   "+colFlag);
        for(int i=1;i< matrix.length;i++){
            for(int j=1;j<matrix[i].length ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowFlag){
            for(int i=0;i<matrix[0].length ; i++){
                matrix[0][i] = 0;
            }
        }
        System.out.println("col len "+matrix[0].length);
        if(colFlag){
            for(int i=0;i<matrix.length ; i++){
                matrix[i][0] = 0;
            }
        }
        for(int[] i : matrix){
            System.out.println(Arrays.toString(i));
        }
    }

}
