class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
        // return selfBitCount(x, y);
    }
    
    public int selfBitCount(int x, int y) {
        int dif = x ^ y;
        int res = 0;
        while(dif > 0) {
            dif &= dif - 1;
            res++;
        }
        return res;
    }
}