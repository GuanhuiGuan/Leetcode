class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0)  return 0;
        // sliding stack
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        
        // find area from top of stack to i || 0 to i if stack is empty
        // stack monotonically increasing
        int i = 0;
        while(i < n){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
                i++;
            }
            else{
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i: i-stack.peek()-1;
                maxA = Math.max(maxA, h*w);
            }
        }
        // rest of stack
        while(!stack.isEmpty()){
            int h = heights[stack.pop()];
            int w = stack.isEmpty()? n: n-stack.peek()-1;
            maxA = Math.max(maxA, h*w);
        }
        return maxA;
    }
}