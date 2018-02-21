class Solution {
    public int findSubstringInWraproundString(String p) {
        // get the max contiguous substring ending with each letter and then sum them up
        int[] count = new int[26];
        
        int subLen = 0;
        for(int i = 0; i < p.length(); i++) {
            // contiguous or wrap around
            if(i > 0 &&
               (p.charAt(i-1)+1 == p.charAt(i) || p.charAt(i-1)-25 == p.charAt(i))) {
                subLen++;
            }
            // otherwise set to 1, one char
            else {
                subLen = 1;
            }
            // update max substring length ending with such letter
            int ci = p.charAt(i)-'a';
            count[ci] = Math.max(count[ci], subLen);
        }
        // sum them up
        int res = 0;
        for(int c: count)   res += c;
        return res;
    }
}