class Solution {
    public int divide(int dividend, int divisor) {
        // overflow: divisor==0 || dividend==min && divisor==-1
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;
        // find sign with exclusive or
        int sign = ((divisor < 0) ^ (dividend < 0))? -1: 1;
        long endLong = Math.abs((long)dividend), sorLong = Math.abs((long)divisor);
        
        long count = sign * divHelper(endLong, sorLong);
        return (int)count;
    }
    
    public long divHelper(long endLong, long sorLong) {
        if(endLong < sorLong) return 0;
        // recursion
        long sum = sorLong;
        long count = 1;
        while(endLong >= sum + sum) {
            sum += sum;
            count += count;
        }
        return count + divHelper(endLong - sum, sorLong);
    }
}