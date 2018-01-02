class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> re = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int lb = nums[i];
            while(i+1 < nums.length && nums[i+1] == nums[i]+1){
                i++;
            }
            if(lb == nums[i])   re.add("" + lb);
            else    re.add(lb + "->" + nums[i]);
        }
        return re;
    }
}