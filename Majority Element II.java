class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // similar to Majority Element, use Boyer Moore
        // two candidates and two counts, at most 2 majority elements here
        int n = nums.length;
        List<Integer> re = new ArrayList<>();
        if(n == 0)  return re;
        int major0 = 0, major1 = 1, count0 = 0, count1 = 0;
        
        // Step 1: find the two major elements
        for(int num: nums) {
            // they cannot be the same and thus use else
            if(major0 == num) count0++;
            else if(major1 == num)  count1++;
            else if(count0 == 0) {
                major0 = num;
                count0++;
            }
            else if(count1 == 0) {
                major1 = num;
                count1++;
            }
            else {
                count0--;
                count1--;
            }
        }
        
        // Step 2: count these two elements to verify
        count0 = count1 = 0;
        for(int num: nums) {
            if(num == major0)   count0++;
            else if(num == major1)  count1++;
        }
        if(count0 > n/3)    re.add(major0);
        if(count1 > n/3)    re.add(major1);
        return re;
    }
}