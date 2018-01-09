class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            reverse(cs, i, Math.min(i+k-1, n-1));
            i += 2*k-1;
        }
        return new String(cs);
    }
    
    public void reverse(char[] cs, int i, int j) {
        while(i < j) {
            char c = cs[i];
            cs[i++] = cs[j];
            cs[j--] = c;
        }
    }
}