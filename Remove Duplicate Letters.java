class Solution {
    public String removeDuplicateLetters(String s) {
        // Recursion, Greedy
        // Take the leftmost letter for each character
        int[] occ = new int[26];
        for(char c: s.toCharArray()) {
            occ[c-'a']++;
        }
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            // Find the lexical smallest char
            if(s.charAt(index) > s.charAt(i))   index = i;
            // Decrement
            if(--occ[s.charAt(i)-'a'] == 0) break;
        }
        // Remove such chars and recurse on the suffix
        return s.length() == 0? "": s.charAt(index) + 
            removeDuplicateLetters(s.substring(index+1).replaceAll("" + s.charAt(index), ""));
    }
}