class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        char[] cs = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(cs[i] != ' ') {
                int j = i;
                while(j < n && cs[j] != ' ') {
                    j++;
                }
                reverse(cs, i, j-1);
                i = j;
            }
        }
        return new String(cs);
    }
    
    public void reverse(char[] cs, int i, int j) {
        while(i < j) {
            char t = cs[i];
            cs[i++] = cs[j];
            cs[j--] = t;
        }
    }
}