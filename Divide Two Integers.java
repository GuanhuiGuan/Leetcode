class Solution {
    public int divide(int dividend, int divisor) {
        // 0 divisor || overflow
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)    return Integer.MAX_VALUE;

        int sign = ((dividend > 0)^(divisor > 0)) ? -1 : 1;
        
        // inside abs should also transformed to long, otherwise overflow
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        int quo = 0;
        while(dvs <= dvd){
            // outer loop handles odd number of products
            long temp = dvs, mul = 1;
            while((temp<<1) <= dvd){
                // inner loop handles even number of products
                mul <<= 1;
                temp <<= 1;
            }
            dvd -= temp;
            quo += mul;
        }
        
        return sign == 1? quo: -quo;
    }
}