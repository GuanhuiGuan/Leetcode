class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0)  return true;
        if(x==0 || y==0)    return x==0? y==z: x==z;
        if(x+y < z) return false;
        // Baczout's identity, k*GCD = k(ax + by)
        return z%GCD(x, y) == 0;
    }
    
//     greatest common divisor
    public int GCD(int x, int y) {
        while(y != 0) {
            int t = y;
            y = x%y;
            x = t;
        }
        return x;
    }
}
