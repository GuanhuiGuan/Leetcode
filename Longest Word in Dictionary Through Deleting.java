class Solution {
    public String findLongestWord(String s, List<String> d) {
        // return sortSub(s, d);
        return iterateSub(s, d);
    }
    
    private String iterateSub(String s, List<String> d) {
        // Iterate and check subarray
        String res = "";
        for(String w: d) {
            int j = 0;
            for(int i = 0; i < s.length() && j < w.length(); i++) {
                if(s.charAt(i) == w.charAt(j))  j++;
            }
            // Is subsequence
            if(j == w.length()) {
                // Longer or equal but smaller lexicographical order
                if(w.length() > res.length() ||
                   w.length() == res.length() && w.compareTo(res) < 0) res = w;
            }
        }
        return res;
    }
    
    private String sortSub(String s, List<String> d) {
        // Sort and check if a word is a subsequence, O(nlogn + nk)
        Collections.sort(d);
        
        String res = "";
        for(String w: d) {
            // Check if it's subsequence
            int j = 0;
            for(int i = 0; i < s.length() && j < w.length(); i++) {
                if(s.charAt(i) == w.charAt(j))  j++;
            }
            // Run through whole word
            if(j == w.length() && w.length() > res.length())    res = w;
        }
        return res;
    }
}