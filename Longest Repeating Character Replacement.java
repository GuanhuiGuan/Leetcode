class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window, find maxcount of a letter in the substring
        // shrink until the rest of letters == k, update maxlength
        int[] letters = new int[26];
        int maxCount = 0, maxLength = 0, i = 0, j = 0;
        
        while(j < s.length()) {
            letters[s.charAt(j)-'A']++;
            maxCount = Math.max(maxCount, letters[s.charAt(j)-'A']);
            
            while((j-i+1) - maxCount > k) {
                letters[s.charAt(i)-'A']--;
                i++;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }
}