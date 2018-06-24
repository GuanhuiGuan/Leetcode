class Solution {
    public int hIndex(int[] citations) {
        return binary_search(citations);
    }
    
    public int fromBack(int[] citations) {
        int h = 0, n = citations.length;
        for(int i = n-1; i >= 0; i--) {
            h = Math.max(h, Math.min(citations[i], n-i));
        }
        return h;
    }
    
    public int binary_search(int[] citations) {
        int n = citations.length, l = 0, r = n-1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(citations[m] == n - m)   return n - m;
            if(citations[m] < n - m + 1)    l = m + 1;
            else    r = m - 1;
        }
        return n - (r + 1);
    }
}