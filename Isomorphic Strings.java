class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] apb = new int[512];
        if(s.length() != t.length())    return false;
        
        for(int i = 0; i < s.length(); i++){
            if(apb[s.charAt(i)] != apb[t.charAt(i) + 256])    return false;
            apb[s.charAt(i)] = i+1;
            apb[t.charAt(i) + 256] = i+1;
        }
        return true;
    }
}