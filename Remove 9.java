class Solution {
    public int newInteger(int n) {
        // add iteratively
        int base = 1, re = 0;
        
        while(n > 0) {
            re += (n%9) * base;
            base *= 10;
            // n divide by 9
            n /= 9;
        }
        return re;
    }
}