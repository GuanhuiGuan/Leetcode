class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        int start = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] != ' ') {
                // add space to not first words
                if(i != 0) {
                    str[start++] = ' ';
                }
                
                // reverse other words, word size j-i
                int j = i;
                while(j < str.length && str[j] != ' ') {
                    str[start++] = str[j++];
                }
                reverse(str, start-(j-i), start-1);
                i = j;
            }
        }
    }
    
    public void reverse(char[] cs, int i, int j) {
        while(i < j) {
            char t = cs[i];
            cs[i++] = cs[j];
            cs[j--] = t;
        }
    }
}