class Solution {
    int[] ori;
    Random rand = new Random();

    public Solution(int[] nums) {
        ori = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    // Fisher-Yates Shuffle
    public int[] shuffle() {
        if(ori == null) return null;
        int[] sf = ori.clone();
        // choose among 0->k at every iteration, (1-1/k)*1/(k-1)
        for(int k = 1; k < sf.length; k++) {
            swap(sf, k, rand.nextInt(k+1));
        }
        return sf;
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */