public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] heights = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            update(matrix[i], heights);
            res = Math.max(res, maxHist(heights));
        }
        return res;
    }

    private void update(char[] row, int[] heights){
        for(int j = 0; j < row.length; j++) {
            heights[j] = row[j] == '1'? heights[j]+1: 0;
        }
    }    

    public int maxHist(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int res = 0;
        // put index of prev >= blocks in stack
        Stack<Integer> stack = new Stack<>();
        for(int j = 0; j <= heights.length; j++) {
            int h = j == heights.length? 0: heights[j];
            if(stack.isEmpty() || heights[stack.peek()] <= h)    stack.push(j);
            else {
                int pre = heights[stack.pop()];
                res = Math.max(res, pre * (stack.isEmpty()? j: j - stack.peek() - 1));
                j--;
            }
        }
        return res;
    }
}