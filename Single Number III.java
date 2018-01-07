class Solution {
    public int[] singleNumber(int[] nums) {
        // 1st pass, get the xor of the two numbers
        int merge = 0;
        for(int n: nums) {
            merge ^= n;
        }
        
        // 2nd pass, get the rightmost set bit, and seperate based on the set bit
        int[] output = new int[2];
        // get rightmost set bit, other bits are all 0
        merge &= -merge;
        
        for(int n: nums) {
            if((n & merge) == 0)    output[0] ^= n;
            else    output[1] ^= n;
        }
        return output;
    }
}