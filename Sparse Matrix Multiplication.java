class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length, p = A[0].length;
        int[][] re = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = 0; k < p; k++){
                    if(A[i][k] != 0 && B[k][j] != 0)    sum += A[i][k]*B[k][j];
                    
                }
                re[i][j] = sum;
            }
        }
        return re;
    }
}