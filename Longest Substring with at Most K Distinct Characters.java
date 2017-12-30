class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;
        int[] temp = new int[256];
        int maxL = 0;
        // how many distinct element
        int cnt = 0;
        
        for(int st = 0, i = 0; i < s.length(); i++){
            // add anyway, duplicate or distinct
            temp[s.charAt(i)]++;
            // new distinct will increase cnt
            if(temp[s.charAt(i)] == 1){
                cnt++;
            }
            // cnt > k
            while(cnt > k){
                // subtract anyway
                temp[s.charAt(st)]--;
                // if none remains, cnt decreases
                if(temp[s.charAt(st)] == 0){
                    cnt--;
                }
                st++;
            }
            
            maxL = Math.max(maxL, i - st + 1);
        }
        return maxL;
    }
}