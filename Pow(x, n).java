class Solution {
    public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n == 0)  return 1;
        if(n < 0){
            // check if overflow
            if(n == Integer.MIN_VALUE){
                n++;
                n = -n;
                x = 1/x;
                return n%2 == 1 ? myPow(x*x, n/2)*x*x : myPow(x*x, n/2)*x;
            }
            
            n = -n;
            x = 1/x;
        }
        return n%2 == 1 ? myPow(x*x, n/2)*x : myPow(x*x, n/2);
    }
}