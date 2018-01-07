class Solution {
    public int findDuplicate(int[] nums) {
        // equal to detect loop in graph; Floyd's Cycle Detection
        int slow = nums[0], fast = nums[slow];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // set to 0
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}