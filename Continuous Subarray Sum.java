class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Use running sum mod by k as key
        // When key exists, (i-j) contains a multiple
        Map<Integer, Integer> map = new HashMap<>();
        // -1 for sum 0, so that if running sum == 0, (i - j) == length of subarray
        map.put(0, -1);
        
        // Sum mod by k won't affect the outcome
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0)  sum %= k;
            if(map.containsKey(sum)) {
                int j = map.get(sum);
                if(i - j > 1)   return true;
            }
            else    map.put(sum, i);
        }
        return false;
    }
}