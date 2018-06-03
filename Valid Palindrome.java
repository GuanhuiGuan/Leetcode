class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        String ls = s.toLowerCase();
        while(i < j) {
            while(i < j && (!Character.isDigit(ls.charAt(i)) && !Character.isLetter(ls.charAt(i))))  i++;
            while(i < j && (!Character.isDigit(ls.charAt(j)) && !Character.isLetter(ls.charAt(j))))  j--;
            if(ls.charAt(i++) != ls.charAt(j--))  return false;
        }
        return true;
    }
}