package Arrays;

import java.util.Arrays;

/**
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/description/
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 *     Any live cell with fewer than two live neighbors dies as if caused by under-population.
 *     Any live cell with two or three live neighbors lives on to the next generation.
 *     Any live cell with more than three live neighbors dies, as if by over-population.
 *     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * */
public class L289 {
    public static void main(String[] args) {
        int[][] array ={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLifeOptimized(array);
        for(int[] a :array)
            System.out.println(Arrays.toString(a));
    }
    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        // make a duplicate matrix first
        int[][] matrix = new int[row][col];
        for(int i=0;i<row;i++){
            matrix[i] = Arrays.copyOf(board[i],board[i].length);
        }

        int[][] neighbors ={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        for(int i=0;i< row;i++){
            for(int j = 0;j<col ; j++){

                int neighborsCount = 0;
                for(int r =0; r<neighbors.length;r++) {
                    int newr = i + neighbors[r][0];
                    int newc = j + neighbors[r][1];
                  //  System.out.println("neighbors for " + i + " " + j + " are " + newr + " " + newc);
                    if((newr < row && newr >-1) && (newc>-1&& newc <col)&& matrix[newr][newc] == 1){
                        neighborsCount += 1;
                    }
                }
                System.out.println();
                System.out.println("neighbor count for "+i+" "+j+" is "+neighborsCount);
                if((neighborsCount > 3 || neighborsCount < 2)&& matrix[i][j] == 1){
                    board[i][j] = 0;
                }
                if(neighborsCount == 3 && matrix[i][j] == 0){
                    board[i][j] = 1;
                }
            }
        }

    }

    public static void gameOfLifeOptimized(int[][] board) {
        int row = board.length;
        int col = board[0].length;



        int[][] neighbors ={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        for(int i=0;i< row;i++){
            for(int j = 0;j<col ; j++){

                int neighborsCount = 0;
                for(int r =0; r<neighbors.length;r++) {
                    int newr = i + neighbors[r][0];
                    int newc = j + neighbors[r][1];
                    //  System.out.println("neighbors for " + i + " " + j + " are " + newr + " " + newc);
                    if((newr < row && newr >-1) && (newc>-1&& newc <col)&& (board[newr][newc] == 1 || board[newr][newc] == -1)){
                        neighborsCount += 1;
                    }
                }
                System.out.println();
              //  System.out.println("neighbor count for "+i+" "+j+" is "+neighborsCount);
                if((neighborsCount > 3 || neighborsCount < 2)&& board[i][j] == 1){
                    board[i][j] = -1;
                }
                if(neighborsCount == 3 && board[i][j] == 0){
                    board[i][j] = 2;
                }
            }
        }

        System.out.println("before");
for(int[] e:board){
    System.out.println(Arrays.toString(e));
}
        System.out.println("after");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }

    }
}
