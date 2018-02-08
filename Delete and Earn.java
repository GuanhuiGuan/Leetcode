class Solution {
    public int deleteAndEarn(int[] nums) {
        // DP
        // maxsum using prev; maxsum not using prev; prev max num
        int sumUse = 0, sumNotUse = 0, prev = -1;
        // the pool of all values, mark their occrrences
        int[] pool = new int[10001];
        for(int num: nums) {
            pool[num]++;
        }
        
        // search from smallest value
        for(int i = 0; i < pool.length; i++) {
            if(pool[i] > 0) {
                // max previous sum
                int max = Math.max(sumUse, sumNotUse);
                // if near previous element, use sumNotUse
                if(i-1 == prev) {
                    sumUse = pool[i]*i + sumNotUse;
                }
                // else, use max of previous sums
                else {
                    sumUse = pool[i]*i + max;
                }
                // update sumNotUse and prev
                sumNotUse = max;
                prev = i;
            }
        }
        return Math.max(sumUse, sumNotUse);
    }
}