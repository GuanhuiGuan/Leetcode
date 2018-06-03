class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int k = t.length();
        
        initMap(map, t);
        
        int i = 0, j = 0, len = Integer.MAX_VALUE, start = 0;
        while(j < s.length()) {
            if(map[s.charAt(j++)]-- > 0) {
                k--;
            }
            
            while(k == 0) {
                // check if it's best result first
                if(len > j - i) {
                    // now j has already incremented, so no need to plus 1
                    len = j - i;
                    start = i;
                }
                // move i forward
                if(map[s.charAt(i++)]++ == 0) {
                    k++;
                }
            }
        }
        return len == Integer.MAX_VALUE? "": s.substring(start, start + len);
    }
    
    public void initMap(int[] map, String t) {
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
    }
}