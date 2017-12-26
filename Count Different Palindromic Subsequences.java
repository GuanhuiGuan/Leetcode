/* REF: https://discuss.leetcode.com/topic/111483/java-96ms-dp-solution-with-detailed-explanation
*/


class Solution {
    public int countPalindromicSubsequences(String S) {
        char[] str = S.toCharArray();
        int n = S.length();
        // #palimdromic subsequences in substring st to end
        int[][] dp = new int[n][n];
        
        // one char is a PS
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        
        // dist: distance between st and end
        for(int dist = 1; dist < n; dist++){
            for(int st = 0; st+dist < n; st++){
                int end = st+dist;
                
                // not the same
                if(str[st] != str[end]){
                    dp[st][end] = dp[st+1][end] + dp[st][end-1] - dp[st+1][end-1];
                }
                // same
                else{
                    // remove duplicates
                    int low = st+1;
                    int high = end-1;
                    while(low <= high && str[low] != str[st]){
                        low++;
                    }
                    while(low <= high && str[high] != str[end]){
                        high--;
                    }
                    
                    // e.g. "aba", b counts b and aba, a counts a and aa
                    if(low > high){
                        dp[st][end] = 2*dp[st+1][end-1] + 2;
                    }
                    // e.g. "aaa", a in mid counts a and aaa, others count aa
                    else if(low == high){
                        dp[st][end] = 2*dp[st+1][end-1] + 1;
                    }
                    // e.g. "aabaa", aba counts a, b, aa, aba, all counts aaa, aba, aaaa, aabaa
                    // aba is redundant
                    else{
                        dp[st][end] = 2*dp[st+1][end-1] - dp[low+1][high-1];
                    }
                }
                dp[st][end] = dp[st][end] < 0 ? dp[st][end] + 1000000007 : dp[st][end]%(1000000007);
            }
        }
        return dp[0][n-1];
    }
}