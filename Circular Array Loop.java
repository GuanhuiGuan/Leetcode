class Solution {
    
    int n = 0;
    
    public boolean circularArrayLoop(int[] nums) {
        return twoPtrs(nums);
    }
    
    private boolean twoPtrs(int[] nums) {
        // Fast and slow indices, set those invalid visited to 0
        // Only one direction loop
        n = nums.length;
        
        for(int i = 0; i < n; i++) {
            // If 0, must be invalid
            if(nums[i] == 0)    continue;
            
            int slow = i, fast = getValue(nums, i);
            // Find loop with 2 indices
            // Stop if fast and its descendent have right direction
            while(nums[fast] * nums[i] > 0 && nums[getValue(nums, fast)] * nums[i] > 0) {                
                if(slow == fast) {
                    // Check if it's one-node loop, break to outer loop
                    if(getValue(nums, slow) == slow)   break;
                    return true;
                }
                
                slow = getValue(nums, slow);
                fast = getValue(nums, getValue(nums, fast));
            }
            
            // When break from inner loop,
            // Set those visited to 0 using slow; Cache the initial value cause it will be set to 0
            int initVal = nums[i];
            slow = i;
            while(nums[slow] * initVal > 0) {
                int nextSlow = getValue(nums, slow);
                nums[slow] = 0;
                slow = nextSlow;
            }
        }
        
        return false;
    }
    
    private int getValue(int[] nums, int i) {
        return (n+i+nums[i])%n;
    }
}