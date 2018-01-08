public class Solution {
    public String reverseWords(String s) {
        // double reversals
        s = s.trim();
        char[] cs = s.toCharArray();
        reverse(cs, 0, cs.length-1);
        
        int start = 0;
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] != ' ') {
                // add space for not first word
                if(i != 0){
                    cs[start] = ' ';
                    start++;
                }
                
                // record word, and then reverse
                int j = i;
                while(j < cs.length && cs[j] != ' ') {
                    cs[start] = cs[j];
                    start++;
                    j++;
                }
                // word length j-i, location [start-(j-i), start-1]
                reverse(cs, start-(j-i), start-1);
                i = j-1;
            }
        }
        
        return new String(cs, 0, start);
    }
    
    public void reverse(char[] cs, int i, int j) {
        while(i < j) {
            char t = cs[i];
            cs[i++] = cs[j];
            cs[j--] = t;
        }
    }
}