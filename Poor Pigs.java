class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // ref: https://leetcode.com/problems/poor-pigs/discuss/94266
        // at most (mTTest/mTDie + 1)^pigs buckets can be tested
        int p = 0;
        int dim = minutesToTest/minutesToDie + 1;
        int mul = 1;
        while(mul < buckets){
            mul *= dim;
            p++;
        }
        return p;
    }
}