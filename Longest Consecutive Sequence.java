class Solution {
    public int longestConsecutive(int[] nums) {
        // hashmap(end, length): save the length, marked by endpoints
        // for new input, connect both ends
        Map<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        
        for(int n: nums){
            // skip duplicates
            if(map.containsKey(n)){
                continue;
            }
            else{
                int lLen = map.containsKey(n-1)? map.get(n-1): 0;
                int rLen = map.containsKey(n+1)? map.get(n+1): 0;
                int len = lLen + 1 + rLen;
                // save n and both endpoints
                map.put(n, len);
                map.put(n-lLen, len);
                map.put(n+rLen, len);
                maxL = Math.max(maxL, len);
            }
        }
        return maxL;
    }
}