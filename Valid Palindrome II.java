class Solution {
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                // omit chars on either end
                // those outside of i and j must be palindrome
                return isPalin(s, i+1, j) || isPalin(s, i, j-1);
            }
        }
        return true;
    }
    
    public boolean isPalin(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--))  return false;
        }
        return true;
    }
}