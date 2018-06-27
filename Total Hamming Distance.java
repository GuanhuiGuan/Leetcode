class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length, res = 0, test = 1;
        // for 32 bits, k num is 1 and (n-k) is 0, res += k*(n-k)
        for(int i = 0; i < 32; i++) {
            // k: count of num has 1 at current bit
            int k = 0;
            for(int num: nums) {
                if((num & test) != 0)   k++;
            }
            res += k * (n-k);
            test <<= 1;
        }
        return res;
    }
}