class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, li = 0, lj = -1, sLen = s.length(), pLen = p.length();
        while(i < sLen) {
            // match chars: advance i and j
            if(j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            // j -> *: mark both positions and advance j
            else if(j < pLen && p.charAt(j) == '*') {
                li = i;
                lj = j;
                j++;
            }
            // last j pos -> *: set j = lj + 1, advance i, and li(* match more substring of s)
            else if(lj != -1) {
                j = lj + 1;
                li++;
                i = li;
            }
            // others
            else    return false;
        }
        // check if rest of p being *
        while(j < pLen && p.charAt(j) == '*')   j++;
        return j == pLen;
    }
}