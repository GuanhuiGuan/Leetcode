class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0)    return 0;
        if(n == 1)  return k;
        // last two posts same/diff, num of ways
        int sameCount = k;
        int diffCount = k*(k-1);
        for(int i = 2; i < n; i++) {
            int temp = diffCount;
            // choose diff color regardless of same/diff
            diffCount = (k-1)*(sameCount + diffCount);
            // choose same as last, and last is diff
            sameCount = temp;
        }
        return sameCount + diffCount;
    }
}