class Solution {
    List<String> re = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
        // DFS sweep, left->right search ), right to left search (
        dfs(s, 0, 0, new char[] {'(', ')'});
        return re;
    }
    
    public void dfs(String s, int is, int js, char[] prt) {
        int counter = 0;
        // sweep till invalid position
        for(int i = is; i < s.length(); i++) {
            if(s.charAt(i) == prt[0])   counter++;
            if(s.charAt(i) == prt[1])   counter--;
            if(counter >= 0)    continue;
            // choose one to delete from j-start to i
            for(int j = js; j <= i; j++) {
                // find the one as first in several repetitive ones
                // start from j since we could remove multiple in a sequence e.g. ((()
                if(s.charAt(j) == prt[1] && (j == js || s.charAt(j-1) != prt[1])) {
                    dfs(s.substring(0, j) + s.substring(j+1), i, j, prt);
                }
            }
            // no need to keep going since only find the first invalid
            return;
        }
        
        // only valid strings(from 1 direction) would reach here
        // check if backwards has been checked
        String rs = new StringBuilder(s).reverse().toString();
        if(prt[0] == '(')   dfs(rs, 0, 0, new char[] {')', '('});
        // else, both ways check, reverse and save
        else    re.add(rs);
    }
}