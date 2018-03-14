class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // replace, delete from s, delete from t
        int i = 0;
        for(; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()) return s.substring(i+1).equals(t.substring(i+1));
                else if(s.length() > t.length()) return s.substring(i+1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i+1));
            }
        }
        return Math.max(s.length(), t.length()) - i == 1;
    }
}