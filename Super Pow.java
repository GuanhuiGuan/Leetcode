class Solution {
    int base = 1337;
    
    public int superPow(int a, int[] b) {
        // (ab)%k = (a%k * b%k)%k
        // a^(b*10 + c)%k = (a^b^10%k * a^c%k)%k
        int res = 1;
        for(int k: b) {
            res = ((_pow(res, 10)%base) * (_pow(a, k)%base))%base;
        }
        return res;
    }
    
    public int _pow(int x, int k) {
        if(k == 0)  return 1;
        if(k == 1)  return x%base;
        // divide and conquer
        return ((_pow(x, k/2)%base) * (_pow(x, k-k/2)%base))%base;
    }
}