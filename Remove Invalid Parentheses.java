class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, new char[] {'(', ')'});
        if(res.isEmpty())   res.add("");
        return res;
    }
    
    public void dfs(String s, int ist, int jst, char[] marks) {
        int count = 0;
        for(int i = ist; i < s.length(); i++) {
            if(s.charAt(i) == marks[0]) count++;
            if(s.charAt(i) == marks[1]) count--;
            if(count >= 0)  continue;
            // j could go up to i to delete last char
            for(int j = jst; j <= i; j++) {
                if(s.charAt(j) == marks[1] && (j == 0 || s.charAt(j-1) != s.charAt(j))) {
                    dfs(s.substring(0, j) + s.substring(j+1), i, j, marks);
                }
            }
            // just find the earliest fix
            return;
        }
        
        // check the other side if this side works
        String rev = new StringBuilder(s).reverse().toString();
        // reverse to correct order
        if(marks[1] == '(') res.add(rev);
        else {
            dfs(rev, 0, 0, new char[] {')', '('});
        }
    }
}