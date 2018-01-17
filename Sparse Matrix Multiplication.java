class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length, col = B[0].length, K = A[0].length;
        int[][] re = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int k = 0; k < K; k++) {
                if(A[i][k] == 0)    continue;
                for(int j = 0; j < col; j++) {
                    if(B[k][j] == 0)    continue;
                    re[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return re;
    }
}