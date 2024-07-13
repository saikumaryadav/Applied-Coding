package Stack;

import java.util.Arrays;
import java.util.Stack;
/***
 * https://leetcode.com/problems/min-stack/
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 *     MinStack() initializes the stack object.
 *     void push(int val) pushes the element val onto the stack.
 *     void pop() removes the element on the top of the stack.
 *     int top() gets the top element of the stack.
 *     int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * */

class MinStack {
    private Stack<Integer> stack;
    int minele;
    public MinStack() {
        stack = new Stack<>();
        minele = 999;
    }

    public void push(int val) {
        System.out.println("Val is "+val);
        System.out.println(stack.empty());
        if(stack.empty()){
            stack.push(val);
            minele = val;
        }
        else{
            if(minele <= val){
                stack.push(val);
            }else{
                int ele = (2*val) - minele;
                stack.push(ele);
                minele = val;
            }
        }
    }

    public void pop() {
        if(!stack.empty()){
            if(stack.peek() >= minele){
                stack.pop();
            }else{

                minele = (2* minele) - stack.peek();
                stack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minele;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(12);
        stack.push(143);
        stack.push(104);
        System.out.println("Stacck is :: "+stack);
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stack=" + stack +
                ", minele=" + minele +
                '}';
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */