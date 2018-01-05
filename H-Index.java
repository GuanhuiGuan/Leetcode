class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // count num of papers with citation i, count[n] is #paper with citation >= n
        int[] count = new int[n+1];
        
        for(int c: citations){
            if(c > n){
                count[n]++;
            }
            else{
                count[c]++;
            }
        }
        
        int sum = 0;
        for(int i = n;i >= 0; i--) {
            sum += count[i];
            if(sum >= i)    return i;
        }
        return 0;
    }
}