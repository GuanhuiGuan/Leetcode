class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] marks = new boolean[S.length()];
        
        // mark bold areas
        for(String word: words) {
            int len = word.length();
            for(int i = 0; i + len <= S.length(); i++) {
                if(word.equals(S.substring(i, i+len))) {
                    for(int j = i; j < i+len; j++) {
                        marks[j] = true;
                    }
                }
            }
        }
        
        // build string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            // if at front or prev is false
            if(marks[i] && (i == 0 || !marks[i-1])) sb.append("<b>");
            sb.append(S.charAt(i));
            // if at back or next is false
            if(marks[i] && (i == S.length()-1 || !marks[i+1])) sb.append("</b>");
        }
        return sb.toString();
    }
}