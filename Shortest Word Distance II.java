class WordDistance {
    private Map<String, List<Integer>> map;
    private int n;

    public WordDistance(String[] words) {
        n = words.length;
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }
            else{
                List<Integer> newL = new ArrayList<>();
                newL.add(i);
                map.put(words[i], newL);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int minL = n+1;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        for(int i = 0, j = 0; i < l1.size() && j < l2.size();){
            int v1 = l1.get(i), v2 = l2.get(j);
            if(v1 < v2){
                minL = Math.min(minL, v2 - v1);
                i++;
            }
            else{
                minL = Math.min(minL, v1 - v2);
                j++;
            }
        }
        return minL;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */