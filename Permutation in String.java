class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;
        // sliding window
        
        // store s1 letters, and delete s2 letters
        int[] occ = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            occ[s1.charAt(i) - 'a']++;
            occ[s2.charAt(i) - 'a']--;
        }
        if(allZero(occ)) return true;
        
        // check remaining letters in s2
        int s = 0, e = s1.length();
        while(e < s2.length()) {
            occ[s2.charAt(e++) - 'a']--;
            occ[s2.charAt(s++) - 'a']++;
            
            if(allZero(occ)) return true;
        }
        
        return false;
    }
    
    public boolean allZero(int[] occ) {
        for(int i = 0; i < 26; i++) {
            if(occ[i] != 0) return false;
        }
        return true;
    }
}