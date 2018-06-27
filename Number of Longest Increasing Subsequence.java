class Solution {
    public int findNumberOfLIS(int[] nums) {
        // DP, record count and length of maxLength ending with each num
        int n = nums.length;
        int[] count = new int[n], len = new int[n];
        
        int maxCount = 0, maxLen = 0;
        for(int i = 0; i < n; i++) {
            // init as 1(at least 1 for both count and len)
            count[i] = 1;
            len[i] = 1;
            
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    // same length
                    if(len[i] == len[j] + 1)    count[i] += count[j];
                    // greater
                    else if(len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            // Update max
            // same length
            if(maxLen == len[i])    maxCount += count[i];
            // greater
            else if(maxLen < len[i]) {
                maxLen = len[i];
                maxCount = count[i];
            }
        }
        
        return maxCount;
    }
}