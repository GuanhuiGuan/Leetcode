class Solution {
    // count palindromes based on letters
    int cons = (int)Math.pow(10, 9)+7;
    Integer[][] dp;
    
    public int countPalindromicSubsequences(String S) {
        TreeSet[] letters = new TreeSet[26];
        int n = S.length();
        dp = new Integer[n+1][n+1];
        for(int i = 0; i < 26; i++) {
            letters[i] = new TreeSet<Integer>();
        }
        
        for(int i = 0; i < n; i++) {
            // add positions of each letter
            Integer c = S.charAt(i) - 'a';
            letters[c].add(i);
        }
        
        // end is out of bound
        return count(0, n, letters);
    }
    
    public int count(int start, int end, TreeSet<Integer>[] letters) {
        if(start >= end) return 0;
        if(dp[start][end] != null)  return dp[start][end];
        
        long sum = 0;
        for(int i = 0; i < 26; i++) {
            // search inwards
            Integer nextStart = letters[i].ceiling(start);
            Integer nextEnd = letters[i].lower(end);    // because end is out of bound
            if(nextStart == null || nextStart >= end)    continue;
            sum++;   // 1 char is a pld
            if(nextStart != nextEnd)    sum++;   // 2 char pld
            // keep searching inwards(end already decremented)
            sum += count(nextStart+1, nextEnd, letters);
        }
        dp[start][end] = (int)(sum%(cons));
        return dp[start][end];
    }
}