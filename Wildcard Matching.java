class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int i = 0, j = 0, ast = -1, s_ast = 0;
        // no dp this problem since it's not related to previous one or two char
        // dual ptrs
        
        // iterate s
        while(i < m) {
            // match: both move forward
            if(j < n && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
                i++;
                j++;
            }
            // asterisk: mark the position and the corresponding one in s
            else if(j < n && p.charAt(j) == '*') {
                ast = j;
                j++;
                s_ast = i;
            }
            // found asterisk before: set j to after ast, s_ast forward(matches)
            else if(ast != -1) {
                j = ast + 1;
                s_ast++;
                i = s_ast;
            }
            // unmatched and no asterisk: false
            else {
                return false;
            }
        }
        // iterate the rest of p, must be asterisk to continue
        while(j < n && p.charAt(j) == '*'){
            j++;
        }
        return j==n;
    }
}