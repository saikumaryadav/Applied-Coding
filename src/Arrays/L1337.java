package Arrays;

import java.util.Collection;
import java.util.List;
import java.util.*;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * 1337. The K Weakest Rows in a Matrix
 * <p>
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <p>
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * <p>
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * Example 1:
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 */
public class L1337 {

    public static void main(String[] args) {
        int[][] array = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(kWeakestRows(array, 3)));

    }

    public static int[] kWeakestRows(int[][] mat, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
           /* int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }*/
            map.put(i, binarySearch(mat[i]));
        }

        Map<Integer, Integer> integerIntegerMap = sortByValues(map);
        int[] result = new int[k];
        List<Integer> keysList  = integerIntegerMap.keySet().stream().toList();
        for(int i = 0;i<k;i++){
            result[i] = keysList.get(i);
        }


        return result;
    }
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
        // Convert the map to a list of entries
        List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by values
        entryList.sort(Map.Entry.comparingByValue());



        // Create a new LinkedHashMap to preserve the sorted order
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static  int binarySearch(int[] array){
        int low = 0;
        int high = array.length;
        // int[][] array = {{1, 1, 0, 0, 0},
        // {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        while(low < high){
            int mid  = low + (high-low)/2;
            if(array[mid]  == 1){
                low = mid+1;
            } else if (array[mid] ==0) {
                high = mid;
            }
        }
        return low;
    }
}
