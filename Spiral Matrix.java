class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> re = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return re;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0, bot = m-1, right = n-1;
        
        while(top <= bot && left <= right) {
            // top go right
            for(int j = left; j <= right; j++)  re.add(matrix[top][j]);
            top++;
            
            // right go down
            for(int i = top; i <= bot; i++)  re.add(matrix[i][right]);
            right--;
            
            if(top > bot || left > right)   break;
            
            // bot go left
            for(int j = right; j >= left; j--)  re.add(matrix[bot][j]);
            bot--;
            
            // left go up
            for(int i = bot; i >= top; i--)  re.add(matrix[i][left]);
            left++;
        }
        return re;
    }
}