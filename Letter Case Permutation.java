class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> letterCasePermutation(String S) {
        bt(S, 0);
        return res;
    }
    
    public void bt(String s, int start) {
        res.add(s);
        
        for(int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                bt(s.substring(0, i) + (char)(c - 'a' + 'A') + s.substring(i+1), i+1);
            }
            else if(c >= 'A' && c <= 'Z') {
                bt(s.substring(0, i) + (char)(c - 'A' + 'a') + s.substring(i+1), i+1);
            }
        }
    }
}