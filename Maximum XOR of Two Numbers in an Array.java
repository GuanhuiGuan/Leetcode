class Solution {
    public int findMaximumXOR(int[] nums) {
        // ref: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049
        // scan bit by bit, find out what each bit is after the xor
        int maxR = 0, ones = 0;
        for(int i = 31; i >= 0; i--){
            // set 1-hot-bit for all 32 bits
            ones = ones | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int n: nums){
                set.add(n & ones);
            }
            
            int temp = maxR | (1 << i);
            for(int item: set){
                if(set.contains(item ^ temp)){
                    maxR = temp;
                }
            }
        }
        return maxR;
    }
}