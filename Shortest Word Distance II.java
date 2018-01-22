class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(words[i]))   list = map.get(words[i]);
            list.add(i);
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1), l2 = map.get(word2);
        int min = Integer.MAX_VALUE, i = 0, j = 0;
        
        if(word1.equals(word2)) {
            while(i < l1.size()-1) {
                min = Math.min(min, l1.get(i+1)-l1.get(i));
                i++;
            }
        }
        else {
            while(i < l1.size() && j < l2.size()) {
                int v1 = l1.get(i), v2 = l2.get(j);
                if(v1 < v2) {
                    min = Math.min(min, v2-v1);
                    i++;
                }
                else {
                    min = Math.min(min, v1-v2);
                    j++;
                }
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */