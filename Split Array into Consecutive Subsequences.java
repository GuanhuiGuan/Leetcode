class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        int pre = Integer.MIN_VALUE;
        int cur = 0;
        int curN = 0;
        // count of arrays ending with pre/cur with size 1/2/>=3
        int p1 = 0, p2 = 0, p3 = 0, c1 = 0, c2 = 0, c3 = 0;
        
        
        for(int i = 0; i < n; pre = cur, p1=c1, p2=c2, p3=c3){
            
            // count the same elements
            for(cur = nums[i], curN = 0; i < n && cur == nums[i]; i++){
                curN++;
            }
                
            // cannot concatenate
            if(cur != pre+1){
                if(p1 != 0 || p2 != 0)  return false;
                c1 = curN;
                c2 = 0;
                c3 = 0;
            }
            // can concatenate
            else{
                if(curN < p1+p2) return false;
                c2 = p1;
                c3 = p2 + Math.min(curN-(p1+p2), p3);
                c1 = Math.max(curN-(p1+p2+p3), 0);
            }
            // p1 = c1;
            // p2 = c2;
            // p3 = c3;
        }
        return p1 == 0 && p2 == 0;
    }
}