class Solution {
    public int[][] generateMatrix(int n) {
        int[][] re = new int[n][n];
        int top = 0, left = 0, bot = n-1, right = n-1;
        int i = 1;
        while(top <= bot && left <= right) {
            for(int k = left; k <= right; k++)  re[top][k] = i++;
            top++;
            for(int k = top; k <= bot; k++)  re[k][right] = i++;
            right--;
            
            if(top > bot || left > right)   break;
            for(int k = right; k >= left; k--)  re[bot][k] = i++;
            bot--;
            for(int k = bot; k >= top; k--)  re[k][left] = i++;
            left++;
        }
        return re;
    }
}