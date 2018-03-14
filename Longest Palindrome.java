class Solution {
    public int longestPalindrome(String s) {
        // count number of pairs, if one count is odd, plus 1
        int[] occ = new int[256];
        for(int i = 0; i < s.length(); i++) {
            occ[s.charAt(i)]++;
        }
        
        int pairs = 0, odd = 0;
        for(int i = 0; i < 256; i++) {
            if(occ[i]%2 == 1) odd = 1;
            pairs += occ[i]/2;
        }
        return 2*pairs + odd;
    }
}