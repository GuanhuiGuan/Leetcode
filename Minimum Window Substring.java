class Solution {
    public String minWindow(String s, String t) {
        // substring problem: map, count && 2ptrs
        // outer loop: check if key exists, and check if count changes
        // inner loop: update min substring, check if key exists and check if count changes
        Map<Character, Integer> map = new HashMap<>();
        for(int k = 0; k < t.length(); k++) {
            map.put(t.charAt(k), map.containsKey(t.charAt(k))? map.get(t.charAt(k))+1: 1);
        }
        int i = 0, count = t.length(), res = 0, relen = Integer.MAX_VALUE;
        
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                if(map.get(c) > 0)  count--;
                map.put(c, map.get(c)-1);
                
                while(count == 0) {
                    if(relen > j-i+1) {
                        res = i;
                        relen = j-i+1;
                    }
                    char prev = s.charAt(i);
                    if(map.containsKey(prev)) {
                        if(map.get(prev) == 0)  count++;
                        map.put(prev, map.get(prev)+1);
                    }
                    i++;
                }
            }
        }
        
        if(relen == Integer.MAX_VALUE)  return "";
        return s.substring(res, res+relen);
    }
}