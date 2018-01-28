class Solution {
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        // union find?
        Map<String, String> map = new HashMap<>();
        for(String[] pair: pairs) {
            String p0 = find(map, pair[0]);
            String p1 = find(map, pair[1]);
            if(!p1.equals(p0))  map.put(p1, p0);
        }
        
        if(words1.length != words2.length)  return false;
        for(int i = 0; i < words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            else if(!find(map, words1[i]).equals(find(map, words2[i])))  return false;
        }
        return true;
    }
    
    public String find(Map<String, String> map, String x) {
        if(!map.containsKey(x)) {
            map.put(x, x);
            return x;
        }
        if(map.get(x) == x) return x;
        String p = find(map, map.get(x));
        map.put(x, p);
        return p;
    }
}