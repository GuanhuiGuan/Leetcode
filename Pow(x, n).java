class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        
        if(n < 0) {
            if(n < 0) {
                n = -n;
                // if not overflow
                if(n >= 0) {
                    x = 1/x;
                }
            }
        }
        
        double prod = myPow(x * x, n/2);
        return n%2 == 0? prod: prod * x;
    }
}