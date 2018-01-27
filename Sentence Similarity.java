class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] pair: pairs) {
            if(!map.containsKey(pair[0]))   map.put(pair[0], new HashSet<>());
            if(!map.containsKey(pair[1]))   map.put(pair[1], new HashSet<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        
        if(words1.length != words2.length)  return false;
        for(int i = 0; i < words1.length; i++) {
            // same words or in library
            if(words1[i].equals(words2[i])) continue;
            else if(!map.containsKey(words1[i])) return false;
            else if(!map.get(words1[i]).contains(words2[i]))    return false;
        }
        return true;
    }
}