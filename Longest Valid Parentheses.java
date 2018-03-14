class Solution {
    public int longestValidParentheses(String s) {
        // DP: if ')', len[i] = len[i-1]+2 + len[i-len[i]]
        int[] len = new int[s.length()];
        
        int left = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') left++;
            if(s.charAt(i) == ')' && left > 0) {
                len[i] = len[i-1] + 2;
                if(i - len[i] >= 0) len[i] += len[i - len[i]];
                left--;
            }
            max = Math.max(max, len[i]);
        }
        return max;
    }
}