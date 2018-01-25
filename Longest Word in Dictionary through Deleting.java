class Solution {
    public String findLongestWord(String s, List<String> d) {
        String re = "";
        
        char[] sc = s.toCharArray();
        for(String w: d) {
            char[] wc = w.toCharArray();
            int i = 0, j = 0;
            while(i < sc.length && j < wc.length) {
                if(sc[i] == wc[j]) {
                    i++;
                    j++;
                }
                else    i++;
            }
            if(j == wc.length) {
                if(re.length() < wc.length) re = w;
                // str.compareTo(str0) sorts strings alphabetically
                if(re.length() == wc.length && w.compareTo(re) < 0)    re = w;
            }
        }
        return re;
    }
}