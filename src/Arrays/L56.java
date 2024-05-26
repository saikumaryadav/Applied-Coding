package Arrays;

import java.util.*;

/***
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * */

//NOTE: WE cannot use treemap here for sorting. because it will not store duplicate starting times. so we can use Array.sort to sort the 2d array by using starting time

public class L56 {
    public static void main(String[] args) {
        int[][] array = {{1,4},{0,4}};//{{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        for(int[] i : array){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("before");
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        System.out.println( merge(array));
        int[][] result = merge(array);
        for(int[] i : result){
            System.out.println(Arrays.toString(i));
        }
    }

    public static  int[][] merge(int[][] intervals) {

        //TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Interval> intervalList = new ArrayList<Interval>();

        for (int i = 0; i < intervals.length; i++) {
            //map.put(intervals[i][0], intervals[i][1]);
            Interval interval = new Interval();
            interval.setKey(intervals[i][0]);
            interval.setValue(intervals[i][1]);
            intervalList.add(interval);
        }
        System.out.println("interval :: " + intervalList);
       // System.out.println("tree map :: " + map);

        Stack<Interval> stack = new Stack<>();

        for (int[] entry : intervals) { //Map.Entry<Integer, Integer> entry : map.entrySet()
            Interval interval = new Interval();
            interval.setKey(entry[0]);
            interval.setValue(entry[1]);

            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                Interval pop = stack.pop();
                if (pop.getValue() >= interval.getKey()) {
                    Interval updatedInterval = new Interval();
                    updatedInterval.setKey(pop.getKey());
                    updatedInterval.setValue(Math.max(pop.getValue(), interval.getValue()));
                    stack.push(updatedInterval);
                } else {
                    stack.push(pop);
                    stack.push(interval);
                }
            }
        }
        System.out.println("stack is :: " + stack);

        int[][] result = new int[stack.size()][2];
        int n = stack.size();
        int index = n-1;
        for (int i = 0; i < n; i++) {
            Interval interval = stack.pop();
            result[index][0] = interval.getKey();
            result[index][1] = interval.getValue();
            index--;
        }



        return result;

    }
}

class Interval {
    Integer key;
    Integer value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
