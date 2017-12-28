class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        // raise the lower; mind the overflow
        for(int n: nums){
            if(n == Integer.MIN_VALUE){
                // nothing is smaller than n; avoid overflow
                lower = n+1;
                continue;
            }
            if(lower == n-1){
                list.add("" + lower);
            }
            else if(lower < n){
                list.add(lower + "->" + (n-1));
            }
            if(n == Integer.MAX_VALUE){
                // everything is added since it's sorted; avoid overflow
                return list;
            }
            lower = n+1;
        }
        
        if(lower == upper){
            list.add("" + lower);
        }
        else if(lower < upper){
            list.add(lower + "->" + upper);
        }
        // else is lower > upper which is good to go
        return list;
    }
}